package com.jiang.sys.domain;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

/**
 * 日志类-记录用户操作行为
 *
 * @author lin.r.x
 */
@Setter
@Getter
public class SysLog implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long logId;           //日志主键
    private String userName;          //用户姓名
    private String logType;            //日志类型:登录日志、登录异常日志、操作日志、操作异常日志
    private String logDescription;           //日志描述
    private String logLevel;           //日志标题
    private String requestAddr;          //请求地址
    private String requestUri;          //URL
    private String requestMethod;          //请求的方法
    private String requestParams;          //提交参数
    private String exceptionInformation;           //异常
    private Timestamp startTime;           //开始时间
    private Timestamp endTime;         //结束时间
    private String requestType;          //请求方式:post/get/put



    public void setParams(String params) {
        this.requestParams = params;
    }

    /**
     * 设置请求参数
     *
     * @param paramMap
     */
    public void setMapToParams(Map<String, String[]> paramMap) {
        if (paramMap == null || paramMap.size()==0) {
            return;
        }
        this.requestParams = JSON.toJSONString(paramMap);
    }


}