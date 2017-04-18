package com.imemyself.common.dialect;

/**
 * MySQL数据库分页方言.
 */
public class MySQLDialect implements Dialect {

    @Override
    public boolean supportLimit() {
        return true;
    }

    @Override
    public boolean supportOffsetLimit() {
        return true;
    }

    @Override
    public String getLimitString(String sql, int offset, int limit) {
        StringBuffer pagingSelect = new StringBuffer(sql.length() + 40).append(sql);
        if (offset > 0) {
            return pagingSelect.append(" limit ").append(offset).append(", ").append(limit).toString();
        } else {
            return pagingSelect.append(" limit ").append(limit).toString();
        }
    }
}