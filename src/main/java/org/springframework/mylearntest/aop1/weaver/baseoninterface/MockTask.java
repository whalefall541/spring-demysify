package org.springframework.mylearntest.aop1.weaver.baseoninterface;

import java.util.Date;

/**
 * @Author: whalefall
 * @Date: 2020/7/16 22:48
 * target object
 */
public class MockTask implements ITask{
	@Override
	public void execute(Date date) {
		System.out.println(" task executed ");
	}
}
