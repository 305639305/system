package com.jiang.sys.domain;

import com.jiang.common.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysDictionaryValue extends BaseDomain {
    /** 版本号 */
    private static final long serialVersionUID = 6007068735989999785L;


    /**  */
    private String dictionaryCategoryCode;

    /**  */
    private String dictionaryValueCode;

    /**  */
    private String dictionaryValueName;

    /**  */
    private String dictionaryValueAttribute;

    /**  */
    private String dictionaryValueDescription;

}