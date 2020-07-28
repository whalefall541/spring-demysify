package org.springframework.mylearntest.aop1.weaver.selfdefinetargetsource;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.mylearntest.aop1.weaver.baseoninterface.ITask;

import java.util.Date;

/**
 * @Author: whalefall
 * @Date: 2020/7/27 22:33
 */
public class Test4AlternativeTargetSource {
	public static void main(String[] args) {
		ITask task1 = new ITask() {
			@Override
			public void execute(Date date) {
				System.out.println("execute in Task1");
			}
		};

		ITask task2 = new ITask() {
			@Override
			public void execute(Date date) {
				System.out.println("execute in Task2");
			}
		};

		ProxyFactory pf = new ProxyFactory();
		TargetSource targetSource = new AlternativeTargetSource(task1,task2);
		pf.setTargetSource(targetSource);
		Object proxy = pf.getProxy();
		for (int i = 0; i < 100; i++) {
			((ITask)proxy).execute(new Date());
		}
	}
}
