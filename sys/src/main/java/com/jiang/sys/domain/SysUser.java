package com.jiang.sys.domain;

import com.jiang.common.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SysUser extends BaseDomain {
    /** 版本号 */
    private static final long serialVersionUID = -259607532476572602L;

    /** 用户账号 */
    private String userName;

    /**  */
    private String password;

    /** 真实姓名 */
    private String realName;

    /**  */
    private Integer age;

    /** 部门代码 */
    private String departmentCode;

    /**  */
    private String email;

    /** 性别 */
    private String gender;

    /** 电话号码 */
    private String phoneNumber;

    /**  */
    private Date birthdate;

    /** 身份证号码 */
    private String identificationCard;

    /** 联系 */
    private String address;

    /** 是否绑定 */
    private String binded;

    /** 用户类型 */
    private String customerType;

    /** MAC地址 */
    private String macAddresses;

    /** 是否限制ip */
    private String limited;

    /**  */
    private String startIp;

    /** 结束ip */
    private String endIp;

    /** 是否授权 */
    private String authorized;

    /** 授权类型 */
    private String authorizedType;

}