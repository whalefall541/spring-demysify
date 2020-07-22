package org.springframework.mylearntest.ioc.initmetod;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mylearntest.ioc.propconfig.SomeBean;

@SuppressWarnings("deprecation")
public class Test4destroy {
	public static void main(String[] args) {
		/*// BeanFactory 版本
		BeanFactory container = new DefaultListableBeanFactory(new ClassPathXmlApplicationContext("beans.xml"));
		SomeBean sb = (SomeBean)container.getBean("someBean");
		sb.doSomething();

		((ConfigurableListableBeanFactory)container).destroySingletons();
		// 应用程序退出 容器关闭*/

		// ApplicationContext 版本
		BeanFactory context = new ClassPathXmlApplicationContext("propconfig/beans.xml");
		((AbstractApplicationContext)context).registerShutdownHook();
		SomeBean sb1 = (SomeBean)context.getBean("someBean");
		sb1.doSomething();
	}
}
