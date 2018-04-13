package com.jiang.sys.service.systemservice.impl;

import com.jiang.sys.dao.SysModuleDao;
import com.jiang.sys.domain.SysModule;
import com.jiang.sys.service.systemservice.interfaceclass.SysModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jiang on 2018/4/6.
 */
@Service("sysModuleService")
public class SysModuleServiceImpl implements SysModuleService {
    @Resource
    private SysModuleDao sysModuleDao;
    @Override
    public void insertSysModule(SysModule sysModule) throws Exception {
        sysModuleDao.insertSysModule(sysModule);
    }
}
