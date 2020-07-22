package org.springframework.mylearntest.ioc.directcode;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

public class PropConfigTest {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		BeanFactory container = bindViaPropertiesFile(beanRegistry);
		FXNewsProvider newsProvider =
				(FXNewsProvider)container.getBean("djNewsProvider");
		newsProvider.getAndPersistNews();
	}

	public static BeanFactory bindViaPropertiesFile(BeanDefinitionRegistry registry) {
		PropertiesBeanDefinitionReader reader =
				new PropertiesBeanDefinitionReader(registry);
		reader.loadBeanDefinitions("classpath:directcode/binding-config.properties");
		return (BeanFactory)registry;
	}
}
