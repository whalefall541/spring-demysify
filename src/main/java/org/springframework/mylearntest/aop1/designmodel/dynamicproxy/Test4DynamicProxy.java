package org.springframework.mylearntest.aop1.designmodel.dynamicproxy;

import org.springframework.mylearntest.aop1.designmodel.staticproxy.IRequestable;
import org.springframework.mylearntest.aop1.designmodel.staticproxy.RequestableImpl;

import java.lang.reflect.Proxy;

@SuppressWarnings("rawtypes")
public class Test4DynamicProxy {
	public static void main(String[] args) {
		// arg1:类加载器 arg2:接口信息 arg3:实现InvocationHandler的类 并传入需要代理的对象
		IRequestable requestable = (IRequestable) Proxy.newProxyInstance(
				Test4DynamicProxy.class.getClassLoader(),
				new Class[]{IRequestable.class},
				new RequestCtrlInvocationHandler(new RequestableImpl()));
		requestable.request();
	}
}
