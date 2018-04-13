package com.jiang.sys.service.systemservice.impl;

import com.alibaba.fastjson.JSON;
import com.jiang.sys.dao.SysUserDao;
import com.jiang.sys.domain.SysUser;
import com.jiang.sys.service.systemservice.interfaceclass.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jiang on 2018/4/3.
 */
@Service(value = "sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;
    public Long insert(SysUser sysUser) throws Exception{
        sysUserDao.insertSysUser(sysUser);
        return sysUser.getId();
    }
}
