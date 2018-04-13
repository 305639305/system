package com.jiang.sys.dao;

import com.jiang.sys.domain.SysDictionaryValue;
import com.jiang.sys.domain.SysDownloadCenter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by jiang on 2018/4/2.
 */
@Mapper
@Component
public interface SysDictionaryValueDao {

     void insertSysDictionaryValue(SysDictionaryValue sysDictionaryValue);
}
