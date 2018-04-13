package com.jiang.sys.domain;

import com.jiang.common.tree.ObjectTreeNodeJoint;
import com.jiang.common.tree.TreeNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class SysDepartmentTree  {

    private HashMap<String, SysDepartmentTreeNode> treeNodesMap	= new HashMap<String, SysDepartmentTreeNode>();
    private List<SysDepartmentTreeNode>				treeNodesList	= new ArrayList<SysDepartmentTreeNode>();

    public SysDepartmentTree(List<SysDepartmentTreeNode> list) {
        initTreeNodeMap(list);
        initTreeNodeList();
    }

    private void initTreeNodeMap(List<SysDepartmentTreeNode> list) {
        SysDepartmentTreeNode treeNode = null;
        for (SysDepartmentTreeNode item : list) {
            treeNodesMap.put(item.getDepartmentCode(), item);
        }

        Iterator<SysDepartmentTreeNode> iter = treeNodesMap.values().iterator();
        SysDepartmentTreeNode parentTreeNode = null;
        while (iter.hasNext()) {
            treeNode = iter.next();
            if (StringUtils.isEmpty(treeNode.getParentDepartmentCode()) ) {
                continue;
            }

            parentTreeNode = treeNodesMap.get(treeNode.getParentDepartmentCode());
            if (parentTreeNode != null) {
                treeNode.setParent(parentTreeNode);
                parentTreeNode.addChild(treeNode);
            }
        }
    }

    private void initTreeNodeList() {
        if (treeNodesList.size() > 0) {
            return;
        }
        if (treeNodesMap.size() == 0) {
            return;
        }
        Iterator<SysDepartmentTreeNode> iter = treeNodesMap.values().iterator();
        SysDepartmentTreeNode treeNode = null;
        while (iter.hasNext()) {
            treeNode = iter.next();
            if (treeNode.getParent() == null) {
                this.treeNodesList.add(treeNode);
                this.treeNodesList.addAll(treeNode.getAllChildren());
            }
        }
    }

    public List<SysDepartmentTreeNode> getTree() {
        return this.treeNodesList;
    }

    public List<SysDepartmentTreeNode> getRoot() {
        List<SysDepartmentTreeNode> rootList = new ArrayList<SysDepartmentTreeNode>();
        if (this.treeNodesList.size() > 0) {
            for (SysDepartmentTreeNode node : treeNodesList) {
                if (node.getParent() == null)
                    rootList.add(node);
            }
        }
        return rootList;
    }

    public SysDepartmentTreeNode getTreeNode(String nodeId) {
        return this.treeNodesMap.get(nodeId);
    }
}