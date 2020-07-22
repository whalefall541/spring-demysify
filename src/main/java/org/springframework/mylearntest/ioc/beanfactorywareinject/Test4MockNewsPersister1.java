package org.springframework.mylearntest.ioc.beanfactorywareinject;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4MockNewsPersister1 {
	public static void main(String[] args) {
		BeanFactory container = new ClassPathXmlApplicationContext("beanfactoryawareinject/beanfactoryawareinject.xml");
		MockNewsPersister1 persister = (MockNewsPersister1)container.getBean("mockPersister1");
		persister.persistNews();
		persister.persistNews();
	}
}