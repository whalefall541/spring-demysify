package org.springframework.mylearntest.aop1.weaver.baseonclass;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.mylearntest.aop1.advice.perclass.PerformanceMethodInterceptor;

/**
 * @Author: whalefall
 * @Date: 2020/7/17 23:31
 */
public class Test4CGLib {
	public static void main(String[] args) {
		ProxyFactory weaver = new ProxyFactory(new Executable());
		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();

		advisor.addMethodName("execute");
		advisor.setAdvice(new PerformanceMethodInterceptor());
		weaver.addAdvisor(advisor);

		Executable proxyObject = (Executable)weaver.getProxy();
		proxyObject.execute();
		// org.springframework.mylearntest.aop.weaver.baseonclass.Executable$$EnhancerBySpringCGLIB$$37e40619
		System.out.println("proxyObject class: " + proxyObject.getClass());
	}
}
