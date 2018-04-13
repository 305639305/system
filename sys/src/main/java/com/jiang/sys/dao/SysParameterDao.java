package com.jiang.sys.dao;

import com.jiang.sys.domain.SysLog;
import com.jiang.sys.domain.SysParameter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by jiang on 2018/4/2.
 */
@Mapper
@Component
public interface SysParameterDao {

     void insertSysParameter(SysParameter sysParameter);
}
