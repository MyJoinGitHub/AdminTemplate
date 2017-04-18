package com.imemyself.domain.system;

import com.imemyself.domain.BaseDomain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RolePermission extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;


    //columns START
    /**
     * 角色标识       db_column: roleId
     */

    private Long roleId;
    /**
     * 权限标识       db_column: permissionId
     */

    private Long permissionId;

    //columns END


    /**
     * 设置角色标识
     */
    public void setRoleId(Long value) {
        this.roleId = value;
    }

    /**
     * 获得角色标识
     */
    public Long getRoleId() {
        return this.roleId;
    }

    /**
     * 设置权限标识
     */
    public void setPermissionId(Long value) {
        this.permissionId = value;
    }

    /**
     * 获得权限标识
     */
    public Long getPermissionId() {
        return this.permissionId;
    }

}
