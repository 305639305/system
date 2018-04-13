package com.jiang.sys.domain;

import com.jiang.common.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SysDictionaryCategory extends BaseDomain {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1347306812676221581L;


    /**  */
    private String dictionaryCategoryCode;

    /**  */
    private String dictionaryCategoryName;

    /**  */
    private String superiorDictionaryCategoryCode;

    /**
     * 类别属性
     */
    private String dictionaryCategoryAttribute;

    /**  */
    private String dictionaryCategoryDescription;

    /**  */
    private String treePath;


}