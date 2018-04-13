package com.jiang.sys.service.systemservice.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiang.common.domain.EasyUiPage;
import com.jiang.sys.dao.SysDepartmentDao;
import com.jiang.sys.domain.SysDepartment;
import com.jiang.sys.domain.SysDepartmentTree;
import com.jiang.sys.domain.SysDepartmentTreeNode;
import com.jiang.sys.service.systemservice.interfaceclass.SysDepartmentService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiang on 2018/4/3.
 */
@Service(value = "sysDepartmentService")
public class SysDepartmentServiceImpl implements SysDepartmentService {
    @Resource
    private SysDepartmentDao sysDepartmentDao;
    @Override
    public void insertSysDepartment(SysDepartment sysDepartment) throws Exception{
        sysDepartmentDao.insertSysDepartment(sysDepartment);
    }

    @Override
    public void updateSysDepartment(SysDepartment sysDepartment) throws Exception {
        sysDepartmentDao.updateSysDepartment(sysDepartment);
    }

    @Override
    public List<SysDepartmentTreeNode> findSysDepartmentTree() {
        List<SysDepartmentTreeNode> list=sysDepartmentDao.findSysDepartmentTree();
        ArrayList toList = new ArrayList();
        return listToTree(list, toList, "0");
    }

    @Override
    public void deleteSysDepartmentById(String id) {
        sysDepartmentDao.deleteSysDepartmentById(id);
    }

    @Override
    public EasyUiPage<SysDepartmentTreeNode> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<SysDepartmentTreeNode> list=sysDepartmentDao.findSysDepartmentTree();
        ArrayList toList = new ArrayList();
        List resultList= listToTree(list, toList, "0");
        EasyUiPage<SysDepartmentTreeNode> page = new EasyUiPage<SysDepartmentTreeNode>();
        PageInfo<SysDepartmentTreeNode> pageInfo = new PageInfo<SysDepartmentTreeNode>(list);
        page.setTotal(pageInfo.getTotal());
        page.setPageNo(pageInfo.getPageNum());
        page.setPageSize(pageInfo.getPageSize());
        page.setRows(resultList);
        return page;

    }

    @Override
    public EasyUiPage<SysDepartmentTreeNode> findByPage(EasyUiPage<SysDepartmentTreeNode> page) {
        return this.findByPage(page.getPageNo(),page.getPageSize());
    }

    private List<SysDepartmentTreeNode> listToTree(List<SysDepartmentTreeNode> fromList, List<SysDepartmentTreeNode> tolist, String parentId) {
        if (CollectionUtils.isEmpty(fromList)) {
            return null;
        }
        int size=fromList.size();
        for (int i = 0; i < size; i++) {
            SysDepartmentTreeNode sysDepartment = fromList.get(i);
            if (sysDepartment == null) {
                continue;
            }

            String pid = sysDepartment.getParentDepartmentCode();
            if ((pid == null) && (parentId != null)) {
                continue;
            }

            if ((parentId == pid) || (pid.equals(parentId))) {
                List<SysDepartmentTreeNode> children = new ArrayList<SysDepartmentTreeNode>();
                sysDepartment.setChildren(children);
                tolist.add(sysDepartment);
                listToTree(fromList, children, sysDepartment.getDepartmentCode());
            }
        }
        return tolist;
    }

}
