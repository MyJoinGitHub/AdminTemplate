package com.imemyself.domain.system;

import com.imemyself.domain.BaseDomain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemParam extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    //columns START
    /**
     * 系统参数编码       db_column: sysParamCode
     */
    private String sysParamCode;
    /**
     * 系统参数值       db_column: sysParamValue
     */
    private String sysParamValue;

    //columns END

    /**
     * 设置系统参数编码
     */
    public void setSysParamCode(String value) {
        this.sysParamCode = value;
    }

    /**
     * 获得系统参数编码
     */
    public String getSysParamCode() {
        return this.sysParamCode;
    }

    /**
     * 设置系统参数值
     */
    public void setSysParamValue(String value) {
        this.sysParamValue = value;
    }

    /**
     * 获得系统参数值
     */
    public String getSysParamValue() {
        return this.sysParamValue;
    }

}
