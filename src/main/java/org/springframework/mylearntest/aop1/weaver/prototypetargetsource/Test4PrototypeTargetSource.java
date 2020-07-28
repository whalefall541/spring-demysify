package org.springframework.mylearntest.aop1.weaver.prototypetargetsource;

import org.junit.Assert;
import org.springframework.aop.framework.Advised;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: whalefall
 * @Date: 2020/7/25 1:46
 */
public class Test4PrototypeTargetSource {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("prototypetargetresource\\prototypetargetsource.xml");
		Object proxy = context.getBean("targetProxy");
		Object targetObj1 = ((Advised)proxy).getTargetSource().getTarget();
		Object targetObj2 = ((Advised)proxy).getTargetSource().getTarget();
		Object targetObj3 = ((Advised)proxy).getTargetSource().getTarget();
		Assert.assertNotSame(targetObj1,targetObj2);
		Assert.assertNotSame(targetObj2,targetObj3);
		Assert.assertNotSame(targetObj1,targetObj3);
	}

}
