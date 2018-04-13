package com.jiang.sys.dao;

import com.jiang.sys.domain.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by jiang on 2018/4/2.
 */
@Mapper
@Component
public interface SysLogDao {

     void insertSysLog(SysLog sysLog);
     void updateSysLog(SysLog sysLog);
}
