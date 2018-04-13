package com.jiang.sys.domain;

import com.jiang.common.domain.BaseDomain;
import com.jiang.common.tree.ObjectTreeNodeJoint;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SysDepartment extends BaseDomain  {
    /** 版本号 */
    private static final long serialVersionUID = 8026026649272527038L;
    /** 部门代码 */
    private String departmentCode;

    /** 上级部门代码 */
    private String parentDepartmentCode;

    /**  */
    private String departmentName;

    /** 部门简称 */
    private String departmentAbbreviation;

    /** 部门类型 */
    private String departmentType;

    /** 联系电话 */
    private String departmentContactPhone;

    /** 联系人 */
    private String departmentContactPerson;

    /**  */
    private String departmentContactAddress;

    /** 排列顺序 */
    private String departmentOrder;

    /** 行政区划 */
    private String departmentAdministrativeDivisions;

    /**  */
    private String departmentLongitude;

    /** 纬度 */
    private String departmentLatitude;

    /** 树路径 （树形结构数据存储方案： 物化路径） */
    private String treePath;

}