package org.springframework.mylearntest.aop1.weaver.proxyfactorybean;

/**
 * @Author: whalefall
 * @Date: 2020/7/22 23:35
 */
public class CounterImpl implements ICounter{
	private int counter;

	@Override
	public void resetCounter() {
		counter = 0;
	}

	@Override
	public int getCounter() {
		counter ++;
		return counter;
	}
}
