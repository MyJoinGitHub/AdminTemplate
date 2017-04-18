package com.imemyself.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * domain层基类，包含基础 的6个系统字段
 * (createPin、createDate、updatePin、updateDate、sysVersion、yn)
 * 默认值：
 * yn=true
 *
 * @author wenjun
 */
public class BaseDomain implements Serializable {
    private static final long serialVersionUID = -1044579091100261195L;
    protected static final String DATE_FORMAT = "yyyy-MM-dd";
    protected static final String TIME_FORMAT = "HH:mm:ss";
    protected static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    protected static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
    public static long DEFAULT_NULL = -1L;

    //columns START
    /**
     * 标识       db_column: id
     */

    private Long id;

    /**
     * 是否删除标志。0：不删除，1：已删除       db_column: isDelete
     */
    private Integer isDelete;
    /**
     * 创建人标识       db_column: creator
     */

    private Long creator;
    /**
     * 修改人标识       db_column: modifier
     */

    private Long modifier;
    /**
     * 创建时间       db_column: createTime
     */

    private Date createTime;
    /**
     * 最后更新时间       db_column: updateTime
     */

    private Date updateTime;
    /**
     * 版本号       db_column: sysVersion
     */

    private Integer sysVersion;
    /**
     * 备注       db_column: remark
     */
    private String remark;

    /**
     * 设置标识
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * 获得标识
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置是否删除标志。0：不删除，1：已删除
     */
    public void setIsDelete(Integer value) {
        this.isDelete = value;
    }

    /**
     * 获得是否删除标志。0：不删除，1：已删除
     */
    public Integer getIsDelete() {
        return this.isDelete;
    }

    /**
     * 设置创建人标识
     */
    public void setCreator(Long value) {
        this.creator = value;
    }

    /**
     * 获得创建人标识
     */
    public Long getCreator() {
        return this.creator;
    }

    /**
     * 设置修改人标识
     */
    public void setModifier(Long value) {
        this.modifier = value;
    }

    /**
     * 获得修改人标识
     */
    public Long getModifier() {
        return this.modifier;
    }

    /**
     * 设置创建时间
     */
    public void setCreateTime(Date value) {
        this.createTime = value;
    }

    /**
     * 获得创建时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 获得创建时间
     */
    public String getCreateTimeString() throws ParseException {
        if (getCreateTime() != null) {
            return new SimpleDateFormat(DATE_FORMAT).format(getCreateTime());
        }
        return null;
    }

    /**
     * 设置创建时间
     */
    public void setCreateTimeString(String value) throws ParseException {
        if (value == null || value.trim().equals("")) {
            setCreateTime(null);
        } else {
            setCreateTime(new SimpleDateFormat(DATE_FORMAT).parse(value));
        }
    }

    /**
     * 获得最后更新时间
     */
    public String getUpdateTimeString() throws ParseException {
        if (getUpdateTime() != null) {
            return new SimpleDateFormat(DATE_FORMAT).format(getUpdateTime());
        }
        return null;
    }

    /**
     * 设置最后更新时间
     */
    public void setUpdateTimeString(String value) throws ParseException {
        if (value == null || value.trim().equals("")) {
            setUpdateTime(null);
        } else {
            setUpdateTime(new SimpleDateFormat(DATE_FORMAT).parse(value));
        }
    }

    /**
     * 设置最后更新时间
     */
    public void setUpdateTime(Date value) {
        this.updateTime = value;
    }

    /**
     * 获得最后更新时间
     */
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 设置版本号
     */
    public void setSysVersion(Integer value) {
        this.sysVersion = value;
    }

    /**
     * 获得版本号
     */
    public Integer getSysVersion() {
        return this.sysVersion;
    }

    /**
     * 设置备注
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * 获得备注
     */
    public String getRemark() {
        return this.remark;
    }
}