package org.springframework.mylearntest.aop1.weaver.hotswaptargetsource;

import org.junit.Assert;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.target.HotSwappableTargetSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mylearntest.aop1.weaver.baseoninterface.ITask;

import java.util.Date;

/**
 * @Author: whalefall
 * @Date: 2020/7/26 19:47
 */
public class Test4HotSwappableTargetSource {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("hotswappabletargetsource\\hotSwappableTargetSource.xml");
		Object proxy = context.getBean("taskProxy");
		Object initTarget = ((Advised)proxy).getTargetSource().getTarget();

		HotSwappableTargetSource hotSwappableTargetSource = (HotSwappableTargetSource)context.getBean(
				"hotSwapTargetSource");
		Object oldTarget = hotSwappableTargetSource.swap(new ITask() {
			@Override
			public void execute(Date date) {
				System.out.println("old target generated by hotSwapTargetSource");
			}
		});

		Object newTarget = ((Advised)proxy).getTargetSource().getTarget();

		// initTarget = org.springframework.mylearntest.aop.weaver.baseoninterface.MockTask@72967906
		// oldTarget = org.springframework.mylearntest.aop.weaver.baseoninterface.MockTask@72967906
		// newTarget = org.springframework.mylearntest.aop.weaver.hotswaptargetsource
		// .Test4HotSwappableTargetSource$1@5b8dfcc1

		Assert.assertSame(initTarget,oldTarget);
		Assert.assertNotSame(initTarget,newTarget);
	}
}
