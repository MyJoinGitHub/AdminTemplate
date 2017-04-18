package com.imemyself.domain.system;

import com.imemyself.domain.BaseDomain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Group extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * 用户组编码       db_column: groupCode
     */
    private String groupCode;
    /**
     * 用户组名称       db_column: groupName
     */
    private String groupName;
    /**
     * 是否删除标志。0：不删除，1：已删除       db_column: isDelete 
     */
    //columns END


    /**
     * 设置用户组编码
     */
    public void setGroupCode(String value) {
        this.groupCode = value;
    }

    /**
     * 获得用户组编码
     */
    public String getGroupCode() {
        return this.groupCode;
    }

    /**
     * 设置用户组名称
     */
    public void setGroupName(String value) {
        this.groupName = value;
    }

    /**
     * 获得用户组名称
     */
    public String getGroupName() {
        return this.groupName;
    }

}
