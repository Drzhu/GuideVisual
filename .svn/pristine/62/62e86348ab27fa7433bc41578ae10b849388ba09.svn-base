package com.guide.utils;

import java.sql.Connection;
import java.util.Date;
import java.util.Properties;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**
 * 运行时SQL输出
 * 
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class SQLInterceptor implements Interceptor {

	public Object intercept(Invocation invocation) throws Throwable {
		RoutingStatementHandler statementHandler = (RoutingStatementHandler) invocation.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler,
				"delegate");
		MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate,
				"mappedStatement");
		System.err.println("-------------------------------------------------" + mappedStatement.getId());
		System.out.println("sql:"+DateUtil.getDetailDate(new Date())+":"+boundSql.getSql());
		return invocation.proceed();
	}

	public Object plugin(Object arg0) {
		return Plugin.wrap(arg0, this);
	}

	public void setProperties(Properties properties) {
	}
}
