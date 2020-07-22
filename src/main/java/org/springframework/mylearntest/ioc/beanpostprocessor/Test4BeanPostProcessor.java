package org.springframework.mylearntest.ioc.beanpostprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4BeanPostProcessor {
	public static void main(String[] args) {
		ApplicationContext beanFactory = new ClassPathXmlApplicationContext("beanpostprocessor/beanpostprocessor.xml");
		DowJonesNewsListener dowJonesNewsListener = (DowJonesNewsListener) beanFactory.getBean("dowJonesNewsListener");
		String encodedPassword = dowJonesNewsListener.getEncodedPassword();
		System.out.println("encodedPassword = " + encodedPassword);
	}
}
