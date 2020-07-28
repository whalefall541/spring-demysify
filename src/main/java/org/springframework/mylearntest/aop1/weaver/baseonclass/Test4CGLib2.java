package org.springframework.mylearntest.aop1.weaver.baseonclass;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.mylearntest.aop1.advice.perclass.PerformanceMethodInterceptor;
import org.springframework.mylearntest.aop1.weaver.baseoninterface.ITask;
import org.springframework.mylearntest.aop1.weaver.baseoninterface.MockTask;

import java.util.Date;

@SuppressWarnings({"rawtypes", "Deprecated"})
public class Test4CGLib2 {
	public static void main(String[] args) {

		ProxyFactory weaver = new ProxyFactory(new MockTask());
		// 强制使用CGLIB
		weaver.setProxyTargetClass(true);
		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
		advisor.setMappedNames("execute");
		advisor.setAdvice(new PerformanceMethodInterceptor());
		weaver.addAdvisor(advisor);

		ITask proxyObj = (MockTask)weaver.getProxy();
		proxyObj.execute(new Date());
		System.out.println("proxyObj.getClass() = " + proxyObj.getClass());

	}
}
