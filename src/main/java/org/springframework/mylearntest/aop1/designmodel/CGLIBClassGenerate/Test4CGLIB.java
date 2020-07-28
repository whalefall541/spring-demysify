package org.springframework.mylearntest.aop1.designmodel.CGLIBClassGenerate;

import org.springframework.cglib.proxy.Enhancer;

public class Test4CGLIB {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Requestable.class);
		enhancer.setCallback(new RequestCtrlCallback());

		Requestable proxy = (Requestable) enhancer.create();
		proxy.request();
	}
}
