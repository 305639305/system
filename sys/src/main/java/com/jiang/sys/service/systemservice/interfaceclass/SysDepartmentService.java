package com.jiang.sys.service.systemservice.interfaceclass;


import com.jiang.common.domain.EasyUiPage;
import com.jiang.sys.domain.SysDepartment;
import com.jiang.sys.domain.SysDepartmentTreeNode;

import java.util.List;

/**
 * Created by jiang on 2018/4/2.
 */
public interface SysDepartmentService {
     void insertSysDepartment(SysDepartment sysDepartment) throws  Exception;
     void updateSysDepartment(SysDepartment sysDepartment) throws  Exception;
     List<SysDepartmentTreeNode> findSysDepartmentTree();
     void deleteSysDepartmentById(String id);

     EasyUiPage<SysDepartmentTreeNode> findByPage(int pageNo, int pageSize);
     EasyUiPage<SysDepartmentTreeNode> findByPage(EasyUiPage<SysDepartmentTreeNode> page);
}
