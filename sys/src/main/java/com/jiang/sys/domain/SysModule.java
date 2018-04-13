package com.jiang.sys.domain;

import com.jiang.common.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysModule extends BaseDomain {
    /** 版本号 */
    private static final long serialVersionUID = 181203897289112812L;
    /**  */
    private String moduleCode;

    /**  */
    private String superiorModuleCode;

    /**  */
    private String moduleName;

    /**  */
    private String modulePath;

    /**  */
    private String moduleLevel;

    /**  */
    private String moduleOrder;

    /** 模块类型：菜单、操作 */
    private String moduleType;

    /**  */
    private String moduleDescription;

    /**  */
    private String moduleIconPath;

    /**  */
    private String moduleOpenMode;

    /** shiro权限 */
    private String permission;

    /**  */
    private String treePath;


}