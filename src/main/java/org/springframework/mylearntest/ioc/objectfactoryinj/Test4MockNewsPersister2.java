package org.springframework.mylearntest.ioc.objectfactoryinj;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4MockNewsPersister2 {
	public static void main(String[] args) {
		BeanFactory container = new ClassPathXmlApplicationContext("objectfactoryinj/objectfactoryinj.xml");
		MockNewsPersister2 persister = (MockNewsPersister2)container.getBean("mockPersister2");
		persister.persistNews();
		persister.persistNews();
	}
}
