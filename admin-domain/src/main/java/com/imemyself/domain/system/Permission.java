package com.imemyself.domain.system;

import com.imemyself.domain.BaseDomain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Permission extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    //columns START
    /**
     * 权限编码       db_column: permissionCode
     */
    private String permissionCode;
    /**
     * 权限名称       db_column: permissionName
     */
    private String permissionName;

    /**
     * 设置权限编码
     */
    public void setPermissionCode(String value) {
        this.permissionCode = value;
    }

    /**
     * 获得权限编码
     */
    public String getPermissionCode() {
        return this.permissionCode;
    }

    /**
     * 设置权限名称
     */
    public void setPermissionName(String value) {
        this.permissionName = value;
    }

    /**
     * 获得权限名称
     */
    public String getPermissionName() {
        return this.permissionName;
    }


}
