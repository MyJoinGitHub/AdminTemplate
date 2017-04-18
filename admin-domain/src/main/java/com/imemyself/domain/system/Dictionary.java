package com.imemyself.domain.system;


import com.imemyself.domain.BaseDomain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dictionary extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * 数据字段编码       db_column: dictionaryCode
     */
    private String dictionaryCode;
    /**
     * 数据字段名称       db_column: dictionaryName
     */
    private String dictionaryName;
    /**
     * 数据字段类型标识       db_column: dictionaryTypeId
     */

    private Long dictionaryTypeId;

    //columns END


    /**
     * 设置数据字段编码
     */
    public void setDictionaryCode(String value) {
        this.dictionaryCode = value;
    }

    /**
     * 获得数据字段编码
     */
    public String getDictionaryCode() {
        return this.dictionaryCode;
    }

    /**
     * 设置数据字段名称
     */
    public void setDictionaryName(String value) {
        this.dictionaryName = value;
    }

    /**
     * 获得数据字段名称
     */
    public String getDictionaryName() {
        return this.dictionaryName;
    }

    /**
     * 设置数据字段类型标识
     */
    public void setDictionaryTypeId(Long value) {
        this.dictionaryTypeId = value;
    }

    /**
     * 获得数据字段类型标识
     */
    public Long getDictionaryTypeId() {
        return this.dictionaryTypeId;
    }


}
