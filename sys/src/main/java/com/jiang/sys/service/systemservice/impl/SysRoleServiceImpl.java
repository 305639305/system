package com.jiang.sys.service.systemservice.impl;


import com.jiang.sys.dao.SysRoleDao;
import com.jiang.sys.domain.SysRole;
import com.jiang.sys.service.systemservice.interfaceclass.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jiang on 2018/4/3.
 */
@Service(value = "sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleDao sysRoleDao;

    @Override
    public void insertSysRole(SysRole sysRole) throws Exception {
        sysRoleDao.insertSysRole(sysRole);
    }

}
