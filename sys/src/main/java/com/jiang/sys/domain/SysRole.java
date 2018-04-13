package com.jiang.sys.domain;


import com.jiang.common.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;

/**
 * SYS_ROLE
 * 
 * @author bianj
 * @version 1.0.0 2018-04-05
 */
@Setter
@Getter
public class SysRole extends BaseDomain {
    /** 版本号 */
    private static final long serialVersionUID = 6608150570731915496L;

    /**  角色代码*/
    private String roleCode;

    /** 上级角色代码 */
    private String superiorRoleCode;

    /** 角色名称 */
    private String roleName;

    /** 角色说明 */
    private String roleDescription;

    /** 树路径 */
    private String treePath;

}