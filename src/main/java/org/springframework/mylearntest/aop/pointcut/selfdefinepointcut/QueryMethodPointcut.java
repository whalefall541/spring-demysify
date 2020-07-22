package org.springframework.mylearntest.aop.pointcut.selfdefinepointcut;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class QueryMethodPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return method.getName().startsWith("get")
				&& targetClass.getPackage().getName().startsWith("...dao");
	}
}
