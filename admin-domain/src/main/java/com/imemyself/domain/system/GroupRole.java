package com.imemyself.domain.system;

import com.imemyself.domain.BaseDomain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GroupRole extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * 用户组标识       db_column: groupId
     */

    private Long groupId;
    /**
     * 角色标识       db_column: roleId
     */

    private Long roleId;

    //columns END

    /**
     * 设置用户组标识
     */
    public void setGroupId(Long value) {
        this.groupId = value;
    }

    /**
     * 获得用户组标识
     */
    public Long getGroupId() {
        return this.groupId;
    }

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


}
