package com.imemyself.domain.system;

import com.imemyself.domain.BaseDomain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GroupUser extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;


    //columns START
    /**
     * 用户组标识       db_column: groupId
     */

    private Long groupId;
    /**
     * 用户标识       db_column: userId
     */

    private Long userId;
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
     * 设置用户标识
     */
    public void setUserId(Long value) {
        this.userId = value;
    }

    /**
     * 获得用户标识
     */
    public Long getUserId() {
        return this.userId;
    }

}
