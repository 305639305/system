package com.jiang.sys.domain;

import com.jiang.common.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysParameter extends BaseDomain {
    /** 版本号 */
    private static final long serialVersionUID = -594657029560163434L;
    /**  */
    private String parameterCode;

    /**  */
    private String parameterValue;

    /**  */
    private String parameterName;

    /**  */
    private String parameterDescription;

    /** 参数属于哪个模块 */
    private String moduleCode;

    /** 参数类型：全局参数、模块参数 */
    private String parameterType;

}