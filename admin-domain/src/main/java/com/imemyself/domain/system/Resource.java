package com.imemyself.domain.system;

import com.imemyself.domain.BaseDomain;

import java.io.Serializable;

public class Resource extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;


    //columns START
    /**
     * 资源编码       db_column: resourceCode
     */
    private String resourceCode;
    /**
     * 资源名称       db_column: resourceName
     */
    private String resourceName;

    //columns END


    /**
     * 设置资源编码
     */
    public void setresourceCode(String value) {
        this.resourceCode = value;
    }

    /**
     * 获得资源编码
     */
    public String getresourceCode() {
        return this.resourceCode;
    }

    /**
     * 设置资源名称
     */
    public void setresourceName(String value) {
        this.resourceName = value;
    }

    /**
     * 获得资源名称
     */
    public String getresourceName() {
        return this.resourceName;
    }

}
