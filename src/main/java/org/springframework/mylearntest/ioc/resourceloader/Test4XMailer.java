package org.springframework.mylearntest.ioc.resourceloader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4XMailer {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resourceloader/xmailer.xml");
		XMailer xMailer = (XMailer) context.getBean("xMailer");
		System.out.println("xMailer = " + xMailer);
	}
}
