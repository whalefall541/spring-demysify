package org.springframework.mylearntest.aop2.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/1 0:43
 */
public class Test4AutoAspectJ {
	public static void main(String[] args) {
		// ApplicationContext context = new ClassPathXmlApplicationContext("annotationawareaspectJautoproxycreator" +
		//		"\\annotationawareaspectJautoproxycreator.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("annotationawareaspectJautoproxycreator/annotationawareaspectJautoproxycreatorxsd.xml");

		Object proxy = context.getBean("target");
		((Foo)proxy).method1();
		((Foo)proxy).method2();
	}
}
