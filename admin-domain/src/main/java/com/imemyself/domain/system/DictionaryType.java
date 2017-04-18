package com.imemyself.domain.system;


import com.imemyself.domain.BaseDomain;

import java.io.Serializable;

public class DictionaryType extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * 数据字段类型编码       db_column: dictionaryTypeCode
     */
    private String dictionaryTypeCode;
    /**
     * 数据字段类型名称       db_column: dictionaryTypeName
     */
    private String dictionaryTypeName;

    /**
     * 设置数据字段类型编码
     */
    public void setDictionaryTypeCode(String value) {
        this.dictionaryTypeCode = value;
    }

    /**
     * 获得数据字段类型编码
     */
    public String getDictionaryTypeCode() {
        return this.dictionaryTypeCode;
    }

    /**
     * 设置数据字段类型名称
     */
    public void setDictionaryTypeName(String value) {
        this.dictionaryTypeName = value;
    }

    /**
     * 获得数据字段类型名称
     */
    public String getDictionaryTypeName() {
        return this.dictionaryTypeName;
    }

}
