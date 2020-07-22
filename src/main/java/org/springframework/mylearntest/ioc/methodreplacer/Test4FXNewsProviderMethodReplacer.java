package org.springframework.mylearntest.ioc.methodreplacer;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mylearntest.ioc.propconfig.FXNewsProvider;

public class Test4FXNewsProviderMethodReplacer {
	public static void main(String[] args) {
		BeanFactory container = new ClassPathXmlApplicationContext("methodreplacer/methodreplacer.xml");
		FXNewsProvider fxNewsProvider = (FXNewsProvider)container.getBean("FXNewsProvider");
		fxNewsProvider.getAndPersistNews();
	}
}
