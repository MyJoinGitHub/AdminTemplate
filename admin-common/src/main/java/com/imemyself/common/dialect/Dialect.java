package com.imemyself.common.dialect;

/**
 * 数据库分页查询方言.
 */
public interface Dialect {

    /**
     * @return 是否支持结果集限定最大条数
     */
    boolean supportLimit();

    /**
     * @return 是否支持结果集行数偏移及限定条数
     */
    boolean supportOffsetLimit();

    /**
     * 分页查询语句
     *
     * @param sql
     *            原生语句
     * @param offset
     *            偏移量
     * @param limit
     *            返回行数
     * @return 分页语句
     */
    String getLimitString(String sql, int offset, int limit);
}
