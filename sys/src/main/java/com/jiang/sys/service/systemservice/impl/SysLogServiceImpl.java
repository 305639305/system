package com.jiang.sys.service.systemservice.impl;


import com.jiang.sys.dao.SysLogDao;
import com.jiang.sys.domain.SysLog;
import com.jiang.sys.service.systemservice.interfaceclass.SysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jiang on 2018/4/3.
 */
@Service(value = "sysLogService")
public class SysLogServiceImpl implements SysLogService {
    @Resource
    private SysLogDao sysLogDao;
    @Override
    public void insertSysLog(SysLog sysLog) {
        sysLogDao.insertSysLog(sysLog);
    }

    @Override
    public void updateSysLog(SysLog sysLog)  {
        sysLogDao.updateSysLog(sysLog);
    }
}
