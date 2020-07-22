package org.springframework.mylearntest.ioc.beanpostprocessor;


public interface PasswordDecodable {
	String getEncodedPassword();
	void setDecodedPassword(String password);
}
