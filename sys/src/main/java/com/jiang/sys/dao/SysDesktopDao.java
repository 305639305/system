package com.jiang.sys.dao;

import com.jiang.sys.domain.SysDepartment;
import com.jiang.sys.domain.SysDesktop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by jiang on 2018/4/2.
 */
@Mapper
@Component
public interface SysDesktopDao {

     void insertSysDesktop(SysDesktop sysDesktop);
}
