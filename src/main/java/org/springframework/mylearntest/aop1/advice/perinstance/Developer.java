package org.springframework.mylearntest.aop1.advice.perinstance;

public class Developer implements IDeveloper{
	@Override
	public void developSoftware() {
		System.out.println("do some developing ...");
	}
}
