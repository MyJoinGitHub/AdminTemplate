package com.imemyself.domain.system;

import com.imemyself.domain.BaseDomain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Role extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;


    //columns START
    /**
     * 角色编码       db_column: roleCode
     */
    private String roleCode;
    /**
     * 角色名称       db_column: roleName
     */
    private String roleName;

    //columns END


    /**
     * 设置角色编码
     */
    public void setRoleCode(String value) {
        this.roleCode = value;
    }

    /**
     * 获得角色编码
     */
    public String getRoleCode() {
        return this.roleCode;
    }

    /**
     * 设置角色名称
     */
    public void setRoleName(String value) {
        this.roleName = value;
    }

    /**
     * 获得角色名称
     */
    public String getRoleName() {
        return this.roleName;
    }

}
