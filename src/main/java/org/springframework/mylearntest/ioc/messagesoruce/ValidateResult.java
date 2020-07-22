package org.springframework.mylearntest.ioc.messagesoruce;

public class ValidateResult {
	private ValidateResult(){}

	private final static ValidateResult validateResult = new ValidateResult();

	public static ValidateResult getInstance4Message(){
		return validateResult;
	}
}
