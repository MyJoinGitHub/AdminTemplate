package com.imemyself.domain.system;

import com.imemyself.domain.BaseDomain;

import java.io.Serializable;

public class PermissionResource extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;


    //columns START
    /**
     * 资源标识       db_column: resourceId
     */

    private Long resourceId;
    /**
     * 权限标识       db_column: permissionId
     */

    private Long permissionId;

    //columns END


    /**
     * 设置资源标识
     */
    public void setresourceId(Long value) {
        this.resourceId = value;
    }

    /**
     * 获得资源标识
     */
    public Long getresourceId() {
        return this.resourceId;
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
