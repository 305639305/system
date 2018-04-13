package com.jiang.sys.aop;

import com.jiang.common.utils.DateUtils;
import com.jiang.common.utils.RequestUtil;
import com.jiang.sys.annotation.ControllerLog;
import com.jiang.sys.domain.SysLog;
import com.jiang.sys.domain.SysUser;
import com.jiang.sys.service.systemservice.interfaceclass.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class LogAspect {


    private static final ThreadLocal<Date> beginTimeThreadLocal =
            new NamedThreadLocal<Date>("ThreadLocal beginTime");
    private static final ThreadLocal<SysLog> logThreadLocal =
            new NamedThreadLocal<SysLog>("ThreadLocal sysLog");

    private static final ThreadLocal<SysUser> currentUser = new NamedThreadLocal<SysUser>("ThreadLocal user");

    @Autowired(required = false)
    private HttpServletRequest request;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Resource
    private SysLogService sysLogService;

    /**
     * Controller层切点 注解拦截
     */
    @Pointcut("@annotation(com.jiang.sys.annotation.ControllerLog)")
    public void controllerAspect() {
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作的开始时间
     *
     * @param joinPoint 切点
     * @throws InterruptedException
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) throws InterruptedException {
        Date beginTime = new Date();
        beginTimeThreadLocal.set(beginTime);//线程绑定变量（该数据只有当前请求的线程可见）  
        if (log.isDebugEnabled()) {//这里日志级别为debug
            log.debug("开始计时: {}  URI: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                    .format(beginTime), request.getRequestURI());
        }


    }

    /**
     * 后置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @SuppressWarnings("unchecked")
    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        //读取session中的用户
        HttpSession session = request.getSession();
        SysUser user = (SysUser) session.getAttribute("user");
        if (user != null) {
            // 打印JVM信息。
            long beginTime = beginTimeThreadLocal.get().getTime();//得到线程绑定的局部变量（开始时间）  
            long endTime = System.currentTimeMillis();  //2、结束时间  
            if (log.isDebugEnabled()) {
                log.debug("计时结束：{}  URI: {}  耗时： {}   最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(endTime),
                        request.getRequestURI(),
                        DateUtils.formatDateTime(endTime - beginTime),
                        Runtime.getRuntime().maxMemory() / 1024 / 1024,
                        Runtime.getRuntime().totalMemory() / 1024 / 1024,
                        Runtime.getRuntime().freeMemory() / 1024 / 1024,
                        (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() + Runtime.getRuntime().freeMemory()) / 1024 / 1024);
            }

            SysLog sysLog = new SysLog();
//            sysLog.setLogId(UUIDUtil.uuid());
            sysLog.setLogDescription(getControllerMethodDescription(joinPoint));
            sysLog.setRequestAddr(RequestUtil.getIpAddress(request));
            sysLog.setRequestUri(request.getRequestURI());
            sysLog.setRequestMethod(joinPoint.getSignature().getName());
            sysLog.setRequestType(request.getMethod());
            Map<String, String[]> params = request.getParameterMap(); //请求提交的参数
            sysLog.setMapToParams(params);
            sysLog.setUserName(user.getUserName());
            sysLog.setStartTime(new Timestamp(beginTime));
            sysLog.setEndTime(new Timestamp(endTime));


            logThreadLocal.set(sysLog);
            //3.再优化:通过线程池来执行日志保存
            threadPoolTaskExecutor.execute(new SaveLogThread(sysLog, sysLogService));
        }

    }

    /**
     * 异常通知 记录操作报错日志
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        SysLog sysLog = logThreadLocal.get();
        sysLog.setLogType("error");
        sysLog.setExceptionInformation(e.getMessage().split("\\n")[0]);
        threadPoolTaskExecutor.execute(new UpdateLogThread(sysLog, sysLogService));
    }


    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return discription
     */
    public String getControllerMethodDescription(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ControllerLog controllerLog = method
                .getAnnotation(ControllerLog.class);
        String discription = controllerLog.description();
        return discription;
    }

    /**
     * 保存日志线程
     */
    private static class SaveLogThread implements Runnable {
        private SysLog sysLog;
        private SysLogService sysLogService;

        public SaveLogThread(SysLog sysLog, SysLogService sysLogService) {
            this.sysLog = sysLog;
            this.sysLogService = sysLogService;
        }

        @Override
        public void run() {
            sysLogService.insertSysLog(sysLog);
        }
    }

    /**
     * 日志更新线程
     */
    private static class UpdateLogThread implements Runnable {
        private SysLog sysLog;
        private SysLogService sysLogService;

        public UpdateLogThread(SysLog sysLog, SysLogService sysLogService) {
            this.sysLog = sysLog;
            this.sysLogService = sysLogService;
        }

        @Override
        public void run() {
            this.sysLogService.updateSysLog(sysLog);
        }
    }
}