package com.imemyself.dao.interceptor;

import com.imemyself.common.dialect.Dialect;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.exceptions.ExceptionFactory;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.*;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 物理真分页组件.
 * <p>
 * 使用方法：
 * </p>
 *
 * <code>
 * 	<plugins>
 *  	<plugin interceptor="com.jd.junion.common.mybatis.plugin.PageableInterceptor">
 *      	<property name="dialect" value="com.jd.junion.common.mybatis.plugin.impl.MySQLDialect"/>
 *  	</plugin>
 *  </plugins>
 * </code>
 *
 * @author infoguofeng
 */
@Intercepts({ @Signature(type = Executor.class, method = "query", args =
        { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class } )})
public class PageableInterceptor implements Interceptor {

    static int INDEX_MAPPED_STATEMENT = 0;	//切点参数中MappedStatement所在索引序列
    static int INDEX_PARAMETER = 1;	//查询参数序列
    static int INDEX_ROW_BOUNDS = 2;	//分页信息序列
    static int INDEX_RESULT_HANDLER = 3;	//结果集Handler序列

    /*
     * 分页方言
     */
    protected Dialect dialect;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        final MappedStatement mappedStatement = this.getMappedStatement(invocation);
        final Object parameter = this.getParameter(invocation);
//        final RowBounds rowBounds = this.getRowBounds(invocation);

        final Pageable pageable = this.getPageable(invocation);
        final Object queryParam = this.getQueryParam(invocation);

        if(pageable != null) {
            final int offset = pageable.getOffset();	//分页偏移量
            final int limit = pageable.getPageSize();	//查询记录条数

            final Long totalCount = this.findCount(mappedStatement, queryParam);

            if (dialect.supportLimit() && (offset != RowBounds.NO_ROW_OFFSET || limit != RowBounds.NO_ROW_LIMIT)) {
                BoundSql boundSql = mappedStatement.getBoundSql(queryParam);
                String sql = boundSql.getSql().trim();

                if (dialect.supportOffsetLimit()) {
                    sql = dialect.getLimitString(sql, offset, limit);
                } else {
                    sql = dialect.getLimitString(sql, RowBounds.NO_ROW_OFFSET, limit);
                }

                this.setMappedStatement(invocation, this.buildMappedStatement(mappedStatement, boundSql, sql));
                this.setRowBounds(invocation, RowBounds.DEFAULT);
                this.setParameter(invocation, queryParam);
            }

            Object result = invocation.proceed();

            Page<?> page = new PageImpl<Object>((List) result, pageable, totalCount);

            List<Page<?>> list = new ArrayList<Page<?>>(1);
            list.add(page);

            return list;
        }

        return invocation.proceed();
    }

    /**
     * 根据方法原有参数，构造新的带有分页条件的MappedStatement
     */
    private MappedStatement buildMappedStatement(MappedStatement ms, BoundSql boundSql, String sql) {
        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(),
                new BoundSqlSqlSource(ms, boundSql, sql), ms.getSqlCommandType());

        builder.resource(ms.getResource());
        builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
        builder.fetchSize(ms.getFetchSize());
        builder.timeout(ms.getTimeout());
        builder.statementType(ms.getStatementType());
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        builder.keyGenerator(ms.getKeyGenerator());
        builder.keyProperty(delimitedArrayToString(ms.getKeyProperties()));
        builder.keyColumn(delimitedArrayToString(ms.getKeyColumns()));
        builder.databaseId(ms.getDatabaseId());

        return builder.build();
    }

    /**
     * 从拦截方法参数中获取MappedStatement
     * @param invocation	切入方法相关信息
     */
    private MappedStatement getMappedStatement(Invocation invocation) {
        return (MappedStatement) invocation.getArgs()[INDEX_MAPPED_STATEMENT];
    }

    /**
     * 设置修改后的MappedStatement到拦截方法参数中
     * @param invocation	切入方法相关信息
     * @param mappedStatement	原有查询MappedStatement
     */
    private void setMappedStatement(Invocation invocation, MappedStatement mappedStatement) {
        invocation.getArgs()[INDEX_MAPPED_STATEMENT] = mappedStatement;
    }

    /**
     * 获取查询参数
     * @param invocation	切入方法相关信息
     * @return	查询参数
     */
    private Object getParameter(Invocation invocation) {
        return invocation.getArgs()[INDEX_PARAMETER];
    }

    /**
     * 获取分页参数
     * @param invocation	切入方法相关信息
     * @return	分页参数包装类
     */
    private RowBounds getRowBounds(Invocation invocation) {
        return (RowBounds) invocation.getArgs()[INDEX_ROW_BOUNDS];
    }

    /**
     * 获取 Pageable
     * @param invocation 切入方法相关信息
     * @return 分页参数包装类
     */
    private Pageable getPageable(Invocation invocation) {
        Object parameter = invocation.getArgs()[INDEX_PARAMETER];
        if (parameter != null) {
            // 单个参数 表现为参数对象
            if(Pageable.class.isAssignableFrom(parameter.getClass())) {
                return (Pageable) parameter;
            } else if (parameter instanceof MapperMethod.ParamMap) {
                // 多个参数 表现为 ParamMap
                MapperMethod.ParamMap<Object> paramMap = (MapperMethod.ParamMap<Object>) parameter;
                for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                    Object value = entry.getValue();

                    if(value != null && Pageable.class.isAssignableFrom(value.getClass())) {
                        return (Pageable) value;
                    }
                }
            }
        }

        return null;
    }

    private Object getQueryParam(Invocation invocation){
        Object parameter = invocation.getArgs()[INDEX_PARAMETER];
        if (parameter != null) {
            if (parameter instanceof MapperMethod.ParamMap) {
                // 多个参数 表现为 ParamMap
                MapperMethod.ParamMap<Object> paramMap = (MapperMethod.ParamMap<Object>) parameter;
                for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();

                    if(value != null && NumberUtils.isNumber(key) && !Pageable.class.isAssignableFrom(value.getClass())) {
                        return value;
                    }
                }
            }
        }

        return null;
    }

    /**
     * 设置新的分页参数到该切入方法中
     * @param invocation		切入方法相关信息
     * @param rowBounds	 新的分页信息
     */
    private void setRowBounds(Invocation invocation, RowBounds rowBounds) {
        invocation.getArgs()[INDEX_ROW_BOUNDS] = rowBounds;
    }

    /**
     * 设置新的查询参数到该切入方法中
     * @param invocation		切入方法相关信息
     * @param parameter	 新的查询参数
     */
    private void setParameter(Invocation invocation, Object parameter) {
        invocation.getArgs()[INDEX_PARAMETER] = parameter;
    }

    private Long findCount(MappedStatement ms, Object queryParam) {
        final Configuration configuration = ms.getConfiguration();

        SqlSession sqlSession = openSessionFromDataSource(configuration, null, false);

        Long totalCount = sqlSession.selectOne(ms.getId() + "_Count", queryParam);

        return totalCount;
    }

    private SqlSession openSessionFromDataSource(Configuration configuration, TransactionIsolationLevel level, boolean autoCommit) {
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            final TransactionFactory transactionFactory = getTransactionFactoryFromEnvironment(environment);
            tx = transactionFactory.newTransaction(environment.getDataSource(), level, autoCommit);
            final Executor executor = configuration.newExecutor(tx, configuration.getDefaultExecutorType());
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            closeTransaction(tx); // may have fetched a connection so lets call close()
            throw ExceptionFactory.wrapException("Error opening session.  Cause: " + e, e);
        } finally {
            ErrorContext.instance().reset();
        }
    }

    private TransactionFactory getTransactionFactoryFromEnvironment(Environment environment) {
        if (environment == null || environment.getTransactionFactory() == null) {
            return new ManagedTransactionFactory();
        }
        return environment.getTransactionFactory();
    }

    private void closeTransaction(Transaction tx) {
        if (tx != null) {
            try {
                tx.close();
            } catch (SQLException ignore) {
                // Intentionally ignore. Prefer previous error.
            }
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        //从插件配置信息中读取名称为dialect的节点
        String dialectClass = properties.getProperty("dialect");

        try {
            dialect = (Dialect) Class.forName(dialectClass).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Can not create dialect instance by dialect:"
                    + dialectClass, e);
        }
    }

    /**
     * 将String类型数组转换为构造MappedStatement所需的字符串（以“,”号拼接）
     * @param in	字符串数组
     * @return 数组为空则返回null,否则返回拼接后的字符串
     */
    private static String delimitedArrayToString(String[] in) {
        if (in == null || in.length == 0) {
            return null;
        } else {
            StringBuffer answer = new StringBuffer();
            for (String str : in) {
                answer.append(str).append(",");
            }
            return answer.toString();
        }
    }

    /**
     * 此类主要用于 根据原有的SqlSource生成新的增加过分页条件后的SqlSource
     */
    public static class BoundSqlSqlSource implements SqlSource {
        private final BoundSql boundSql;

        public BoundSqlSqlSource(MappedStatement ms, BoundSql boundSql, String sql) {
            this.boundSql = buildBoundSql(ms, boundSql, sql);
        }

        public BoundSql getBoundSql(Object parameterObject) {
            return boundSql;
        }

        /**
         * 构建新的BoundSql
         */
        private BoundSql buildBoundSql(MappedStatement ms, BoundSql boundSql, String sql) {
            BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql,
                    boundSql.getParameterMappings(), boundSql.getParameterObject());
            for (ParameterMapping mapping : boundSql.getParameterMappings()) {
                String prop = mapping.getProperty();
                if (boundSql.hasAdditionalParameter(prop)) {
                    newBoundSql.setAdditionalParameter(prop, boundSql.getAdditionalParameter(prop));
                }
            }
            return newBoundSql;
        }

    }
}

