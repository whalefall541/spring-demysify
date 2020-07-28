package org.springframework.mylearntest.aop1.designmodel.staticproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceControlRequestableProxy implements IRequestable{
	private static final Logger logger = LoggerFactory.getLogger(ServiceControlRequestableProxy.class);
	private IRequestable requestable;

	public ServiceControlRequestableProxy(IRequestable target) {
		this.requestable = target;
	}

	@Override
	public void request() {
		System.out.println("request process in proxy class");
		requestable.request();
	}

	public static void main(String[] args) {
		IRequestable target = new RequestableImpl();// 需要被代理的对象
		IRequestable proxy = new ServiceControlRequestableProxy(target); // 以构造方法形式将被代理对象传入代理者中
		proxy.request();// 让代理者去处理请求
	}
}
