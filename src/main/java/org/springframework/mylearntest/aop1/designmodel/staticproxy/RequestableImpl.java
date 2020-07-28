package org.springframework.mylearntest.aop1.designmodel.staticproxy;

public class RequestableImpl implements IRequestable{
	@Override
	public void request() {
		System.out.println("request process in target class");
	}
}
