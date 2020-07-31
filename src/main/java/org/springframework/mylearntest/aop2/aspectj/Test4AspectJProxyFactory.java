package org.springframework.mylearntest.aop2.aspectj;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @Author: WhaleFall541
 * @Date: 2020/7/31 23:46
 */
public class Test4AspectJProxyFactory {
	public static void main(String[] args) {
		AspectJProxyFactory weaver = new AspectJProxyFactory();
		weaver.setProxyTargetClass(true);
		weaver.setTarget(new Foo());
		weaver.addAspect(PerformanceTraceAspect.class);
		Object proxy = weaver.getProxy();
		((Foo)proxy).method1();
		((Foo)proxy).method2();
	}
}
