package org.springframework.mylearntest.aop.designmodel.staticproxy;

public class RequestableImpl implements IRequestable{
	@Override
	public void request() {
		System.out.println("request process in target class");
	}
}
