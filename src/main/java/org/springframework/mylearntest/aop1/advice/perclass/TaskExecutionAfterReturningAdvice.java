package org.springframework.mylearntest.aop1.advice.perclass;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.lang.reflect.Method;

@SuppressWarnings("rawtypes")
public class TaskExecutionAfterReturningAdvice implements AfterReturningAdvice {
	private SqlMapClientTemplate sqlMapClientTemplate;

	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}

	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		Class clazz = target.getClass();
		getSqlMapClientTemplate().insert("BATCH.insertTaskStatus", clazz.getName());
	}
}
