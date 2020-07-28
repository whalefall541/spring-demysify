package org.springframework.mylearntest.aop1.weaver.proxyfactorybean;

import org.springframework.aop.support.DelegatePerTargetObjectIntroductionInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: whalefall
 * @Date: 2020/7/22 23:51
 * @see DelegatePerTargetObjectIntroductionInterceptor
 * using DelegatePerTargetObjectIntroductionInterceptor
 */
public class Test4ProxyFactoryBean2 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("proxyfactorybean\\proxyfactorybean2.xml");
		Object proxy1 = context.getBean("introducedTask");
		Object proxy2 = context.getBean("introducedTask");

		System.out.println(((ICounter)proxy1).getCounter());//1
		System.out.println(((ICounter)proxy1).getCounter());//2
		System.out.println(((ICounter)proxy2).getCounter());//1
	}
}
