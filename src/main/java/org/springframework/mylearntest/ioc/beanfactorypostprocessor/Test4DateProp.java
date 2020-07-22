package org.springframework.mylearntest.ioc.beanfactorypostprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4DateProp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanfactorypostprocessor/datepropertyeditor2.xml");
		DatePropertyEditor datePropertyEditor = (DatePropertyEditor) context.getBean("datePropertyEditor");
		datePropertyEditor.setAsText("2020/06/20");
	}
}
