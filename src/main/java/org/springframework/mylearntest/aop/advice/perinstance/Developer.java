package org.springframework.mylearntest.aop.advice.perinstance;

public class Developer implements IDeveloper{
	@Override
	public void developSoftware() {
		System.out.println("do some developing ...");
	}
}
