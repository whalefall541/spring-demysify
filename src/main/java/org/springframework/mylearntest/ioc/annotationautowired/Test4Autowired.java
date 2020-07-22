package org.springframework.mylearntest.ioc.annotationautowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4Autowired {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext
				("annotationautowired/annotationautowired.xml");
		FXNewsProvider provider = (FXNewsProvider) context.getBean("FXNewsProvider");
		provider.getAndPersistNews();
	}
}
