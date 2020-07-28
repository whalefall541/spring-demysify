package org.springframework.mylearntest.aop1.designmodel.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RequestCtrlInvocationHandler implements InvocationHandler {
	private Object target;

	public RequestCtrlInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("reflect invoke before target method");
		if ("request".equals(method.getName())) {
			System.out.println("dynamic proxy target method");
			return method.invoke(target, args);
		}
		return null;
	}
}
