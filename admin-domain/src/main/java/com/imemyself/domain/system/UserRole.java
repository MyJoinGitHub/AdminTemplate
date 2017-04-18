package com.imemyself.domain.system;

import com.imemyself.domain.BaseDomain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserRole extends BaseDomain implements Serializable{
    private static final long serialVersionUID = 5454155825314635342L;

                        
    //columns START
        /**
     * 用户标识       db_column: userId 
     */    
    
    private Long userId;
        /**
     * 角色标识       db_column: roleId 
     */    
    
    private Long roleId;

        //columns END  

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
