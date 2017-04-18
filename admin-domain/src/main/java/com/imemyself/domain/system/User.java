package com.imemyself.domain.system;

import com.imemyself.domain.BaseDomain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    public static final String FORMAT_LAST_LOGIN_TIME = DATE_FORMAT;


    //columns START
    /**
     * 用户编码       db_column: userCode
     */
    private String userCode;
    /**
     * 用户名称       db_column: userName
     */
    private String userName;
    /**
     * 用户密码       db_column: userPassword
     */
    private String userPassword;
    /**
     * 用户固定电话       db_column: userTelephone
     */
    private String userTelephone;
    /**
     * 用户移动电话       db_column: userMobile
     */
    private String userMobile;
    /**
     * 用户邮箱       db_column: userEmail
     */
    private String userEmail;
    /**
     * 用户地址       db_column: userAddress
     */
    private String userAddress;
    /**
     * 用户最后登录时间       db_column: lastLoginTime
     */

    private Date lastLoginTime;

    //columns END

    /**
     * 设置用户编码
     */
    public void setUserCode(String value) {
        this.userCode = value;
    }

    /**
     * 获得用户编码
     */
    public String getUserCode() {
        return this.userCode;
    }

    /**
     * 设置用户名称
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * 获得用户名称
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置用户密码
     */
    public void setUserPassword(String value) {
        this.userPassword = value;
    }

    /**
     * 获得用户密码
     */
    public String getUserPassword() {
        return this.userPassword;
    }

    /**
     * 设置用户固定电话
     */
    public void setUserTelephone(String value) {
        this.userTelephone = value;
    }

    /**
     * 获得用户固定电话
     */
    public String getUserTelephone() {
        return this.userTelephone;
    }

    /**
     * 设置用户移动电话
     */
    public void setUserMobile(String value) {
        this.userMobile = value;
    }

    /**
     * 获得用户移动电话
     */
    public String getUserMobile() {
        return this.userMobile;
    }

    /**
     * 设置用户邮箱
     */
    public void setUserEmail(String value) {
        this.userEmail = value;
    }

    /**
     * 获得用户邮箱
     */
    public String getUserEmail() {
        return this.userEmail;
    }

    /**
     * 设置用户地址
     */
    public void setUserAddress(String value) {
        this.userAddress = value;
    }

    /**
     * 获得用户地址
     */
    public String getUserAddress() {
        return this.userAddress;
    }

    /**
     * 获得用户最后登录时间
     */
    public String getLastLoginTimeString() throws ParseException {
        if (getLastLoginTime() != null) {
            return new SimpleDateFormat(FORMAT_LAST_LOGIN_TIME).format(getLastLoginTime());
        }
        return null;
    }

    /**
     * 设置用户最后登录时间
     */
    public void setLastLoginTimeString(String value) throws ParseException {
        if (value == null || value.trim().equals("")) {
            setLastLoginTime(null);
        } else {
            setLastLoginTime(new SimpleDateFormat(FORMAT_LAST_LOGIN_TIME).parse(value));
        }
    }

    /**
     * 设置用户最后登录时间
     */
    public void setLastLoginTime(Date value) {
        this.lastLoginTime = value;
    }

    /**
     * 获得用户最后登录时间
     */
    public Date getLastLoginTime() {
        return this.lastLoginTime;
    }

}
