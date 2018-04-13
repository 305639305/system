package com.jiang.sys.dao;

import com.jiang.sys.domain.SysLog;
import com.jiang.sys.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by jiang on 2018/4/2.
 */
@Mapper
@Component
public interface SysRoleDao {

     void insertSysRole(SysRole sysRole);
}
