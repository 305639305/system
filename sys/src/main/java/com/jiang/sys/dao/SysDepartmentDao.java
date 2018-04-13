package com.jiang.sys.dao;

import com.jiang.sys.domain.SysDepartment;
import com.jiang.sys.domain.SysDepartmentTreeNode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jiang on 2018/4/2.
 */
@Mapper
@Component
public interface SysDepartmentDao {

     void insertSysDepartment(SysDepartment sysDepartment);
     void updateSysDepartment(SysDepartment sysDepartment) throws  Exception;
     List<SysDepartmentTreeNode> findSysDepartmentTree();
     void deleteSysDepartmentById(String id);
}
