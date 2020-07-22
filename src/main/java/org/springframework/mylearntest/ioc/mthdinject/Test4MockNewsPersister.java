package org.springframework.mylearntest.ioc.mthdinject;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4MockNewsPersister {
	public static void main(String[] args) {
		BeanFactory container = new ClassPathXmlApplicationContext("mthdinject/mthdinject.xml");
		MockNewsPersister persister = (MockNewsPersister)container.getBean("mockPersister");
		persister.persistNews();
		persister.persistNews();
	}
}
