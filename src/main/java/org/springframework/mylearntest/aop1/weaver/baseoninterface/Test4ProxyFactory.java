package org.springframework.mylearntest.aop1.weaver.baseoninterface;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.mylearntest.aop1.advice.perclass.PerformanceMethodInterceptor;

import java.util.Date;

/**
 * @Author: whalefall
 * @Date: 2020/7/15 22:53
 */


public class Test4ProxyFactory {
	public static void main(String[] args) {
		/*// 1. 传入需要织入的对象
		ProxyFactory weaver = new ProxyFactory(new Tester());
		// weaver.setTarget(new Tester());

		// 2. 将要应用到目标对象的Advisor绑定到织入器上
		ApplicationContext context = new ClassPathXmlApplicationContext("advisor/defaultadvisor/defaultadvisor.xml");
		Advisor advisor = (Advisor) context.getBean("advisor");
		weaver.addAdvisor(advisor);

		Object proxyObject =  weaver.getProxy();
		System.out.println(proxyObject.getClass());
		// out: class org.springframework.mylearntest.aop.advice.perinstance.Tester$$EnhancerBySpringCGLIB$$8e739b5b
		*/

		// 目标类有实现接口的用法
		// 只要不将ProxyFactory的optimize和proxyTargetClass设置为true
		// 那么ProxyFactory都会按照面向接口进行代理
		MockTask task = new MockTask();
		ProxyFactory weaver = new ProxyFactory(task);
		// weaver.setInterfaces(new Class[]{ITask.class});
		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
		advisor.setMappedNames("execute");
		advisor.setAdvice(new PerformanceMethodInterceptor());
		weaver.addAdvisor(advisor);
		ITask proxyObj = (ITask)weaver.getProxy();
		// com.sun.proxy.$Proxy0
		// System.out.println(proxyObj.getClass());
		// 只能强制转化为接口类型，不能转化为实现类类型 否则会抛出ClassCastException
		// ITask proxyObj = (MockTask)weaver.getProxy();
		proxyObj.execute(new Date());

	}
}
