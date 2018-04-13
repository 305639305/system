package com.jiang.sys.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class SysDepartmentTreeNode extends SysDepartment  {

    @JsonIgnore
    private SysDepartmentTreeNode parent;
    //当前节点的二子节点
    private List<SysDepartmentTreeNode> children = new ArrayList<SysDepartmentTreeNode>();
    //当前节点的子孙节点
    @JsonIgnore
    private List<SysDepartmentTreeNode> allChildren = new ArrayList<SysDepartmentTreeNode>();
    //是否是父亲节点
    private Boolean isParent=false;

    public void addChild(SysDepartmentTreeNode treeNode){
        this.children.add(treeNode);
        if(!this.isParent){
            this.isParent=true;
        }
    }
    public void removeChild(SysDepartmentTreeNode treeNode){
        this.children.remove(treeNode);
        if(this.isParent && this.children.isEmpty()){
            this.isParent=false;
        }
    }
    public List<SysDepartmentTreeNode> getAllChildren() {
        if(this.allChildren.isEmpty()){
            for(SysDepartmentTreeNode treeNode : this.children){
                this.allChildren.add(treeNode);
                this.allChildren.addAll(treeNode.getAllChildren());
            }
        }
        return this.allChildren;
    }
}