package org.springframework.mylearntest.ioc.resourceloader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4ContextBoo {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resourceloader/resourceloader4ContextBoo.xml");
		FooBarImplApplicationContextAware fooBar = (FooBarImplApplicationContextAware) context.getBean("fooBar");
		System.out.println("fooBar = " + fooBar);
	}
}
