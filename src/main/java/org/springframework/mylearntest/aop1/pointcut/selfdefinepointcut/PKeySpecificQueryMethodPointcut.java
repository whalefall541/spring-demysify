package org.springframework.mylearntest.aop1.pointcut.selfdefinepointcut;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class PKeySpecificQueryMethodPointcut extends DynamicMethodMatcherPointcut {
	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		if (method.getName().startsWith("get")
				&& targetClass.getPackage().getName().startsWith("..dao")) {
			if (!ArrayUtils.isEmpty(args)) {
				return StringUtils.equals("12345",args[0].toString());
			}
		}
		return false;
	}
}
