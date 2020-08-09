package org.springframework.mylearntest.aop2.introduction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mylearntest.aop1.weaver.proxyfactorybean.ICounter;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/9 17:10
 */
public class Test4IntroductionAspect {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("introductionaspect/introductionaspect.xml");
		Object task1 = context.getBean("task");
		Object task2 = context.getBean("task");

		System.out.println(((ICounter)task1).getCounter());
		System.out.println(((ICounter)task1).getCounter());
		System.out.println(((ICounter)task2).getCounter());
	}
}
