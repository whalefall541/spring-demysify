package org.springframework.mylearntest.ioc.directcode;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * 通过编码方式使用BeanFactory实现FX新闻相关类的注册及绑定
 * 本内容来自书籍Spring揭密
 * 代码搬运于此
 */
public class BeanFactoryFX {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		BeanFactory container = bindViaCode(beanRegistry);
		FXNewsProvider newsProvider = (FXNewsProvider)container.getBean("djNewsProvider");
		newsProvider.getAndPersistNews();
	}

	// 因为传入的DefaultListableBeanFactory同
	// 时实现了BeanFactory和BeanDefinitionRegistry接口，所以，这样做强制类型转换不会出
	// 现问题。但需要注意的是，单纯的BeanDefinitionRegistry是无法强制转换到BeanFactory
	// 类型的！
	public static BeanFactory bindViaCode(BeanDefinitionRegistry registry) {
		AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class, 0, true);
		AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class,0, true);
		AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class, 0,true);
		// 将bean定义注册到容器中
		registry.registerBeanDefinition("djNewsProvider", newsProvider);
		registry.registerBeanDefinition("djListener", newsListener);
		registry.registerBeanDefinition("djPersister", newsPersister);
		// 指定依赖关系
		// 1. 可以通过构造方法注入方式
		/*ConstructorArgumentValues argValues = new ConstructorArgumentValues();
		argValues.addIndexedArgumentValue(0, newsListener);
		argValues.addIndexedArgumentValue(1, newsPersister);
		newsProvider.setConstructorArgumentValues(argValues);*/
		// 2. 或者通过setter方法注入方式
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("newsListener",newsListener));
		propertyValues.addPropertyValue(new PropertyValue("newPersistener",newsPersister));
		newsProvider.setPropertyValues(propertyValues);
		// 绑定完成 2
		return (BeanFactory)registry;
	}
}
