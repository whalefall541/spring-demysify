package org.springframework.mylearntest.aop1.advice.perinstance;

public class Tester implements ITester{
	private  boolean busyAsTester;

	public void setBusyAsTester(boolean busyAsTester) {
		this.busyAsTester = busyAsTester;
	}

	@Override
	public boolean isBusyAsTester() {
		return busyAsTester;
	}

	@Override
	public void testSoftware() {
		System.out.println("do some developing and test ...");
	}
}
