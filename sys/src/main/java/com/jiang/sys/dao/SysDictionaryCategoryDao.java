package com.jiang.sys.dao;

import com.jiang.sys.domain.SysDictionaryCategory;
import com.jiang.sys.domain.SysDictionaryValue;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by jiang on 2018/4/2.
 */
@Mapper
@Component
public interface SysDictionaryCategoryDao {

     void insertSysDictionaryCategory(SysDictionaryCategory sysDictionaryCategory);
}
