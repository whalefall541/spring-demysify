package org.springframework.mylearntest.ioc.propconfig;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class Test {
	public static void main(String[] args) {
		/*ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		SomeBean someBean= (SomeBean) context.getBean("someBean");
		someBean.doSomething();*/

		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		BeanFactory container = bindViaXMLFile(beanRegistry);
		FXNewsProvider newsProvider = (FXNewsProvider)container.getBean("djNewsProvider");
		newsProvider.getAndPersistNews();
	}

	public static BeanFactory bindViaXMLFile(BeanDefinitionRegistry registry) {
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		reader.loadBeanDefinitions("classpath:propconfig/news-config.xml");
		return (BeanFactory)registry; // 或者直接
		//return new XmlBeanFactory(new ClassPathResource("news-config.xml"));
	}
}
