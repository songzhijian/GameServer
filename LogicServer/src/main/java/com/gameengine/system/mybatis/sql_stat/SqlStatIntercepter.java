package com.gameengine.system.mybatis.sql_stat;

import com.dreamfun.opg.utils.GameLoggerFactory;
import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPDataSource;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.slf4j.Logger;

import java.sql.Statement;
import java.util.Properties;

@Intercepts({@Signature(
        type = StatementHandler.class,
        method = "batch",
        args = {Statement.class})
        , @Signature(
        type = StatementHandler.class,
        method = "update",
        args = {Statement.class})
        , @Signature(
        type = StatementHandler.class,
        method = "query",
        args = {Statement.class, ResultHandler.class})})
public class SqlStatIntercepter implements Interceptor {
    private static final Logger logger = GameLoggerFactory.getLogger(SqlStatIntercepter.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (!SqlStatUtils.open) {
            return invocation.proceed();
        }
        Object val = null;
        try {
            SqlStatUtils.resetPeriodStat();

            RoutingStatementHandler statementHandler = (RoutingStatementHandler) invocation.getTarget();
            BaseStatementHandler baseStatementHandler = (BaseStatementHandler) SystemMetaObject.forObject(statementHandler).getValue("delegate");
            MappedStatement statement = (MappedStatement) SystemMetaObject.forObject(baseStatementHandler).getValue("mappedStatement");
            Environment environment = statement.getConfiguration().getEnvironment();

            BoneCPDataSource boneCPDataSource = (BoneCPDataSource) environment.getDataSource();
            BoneCP pool = boneCPDataSource.getPool();
            if(pool != null) {
                SqlStatUtils.periodPoolStat(pool);
            }

            long start = System.currentTimeMillis();
            val = invocation.proceed();
            long cost = System.currentTimeMillis() - start;

            boolean slow = false;
            if (cost >= SqlStatUtils.SLOW_LIMIT) {
                slow = true;
                logger.info("SLOW SQL : {}, cost time {} ms", statement.getId(), cost);
            }

            String[] tableNameAndOperation = getTableNameAndOperation(statement.getId());
            SqlStatUtils.stat(tableNameAndOperation[0], tableNameAndOperation[1], slow);
            SqlStatUtils.periodStat(tableNameAndOperation[0]);
        } catch (Exception e) {
            logger.error("SqlStatIntercepter intercept", e);
        }
        return val;
    }


    private String[] getTableNameAndOperation(String mapperId) {
        String[] arr = StringUtils.split(mapperId,'.');
        int size = arr.length;
        String operation = arr[size - 1];
        String tableName = arr[size - 2];
        if (tableName.endsWith("Mapper")) {
            tableName = tableName.substring(0, tableName.length() - 6);
        }
        return new String[]{tableName, operation};
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {}
}

