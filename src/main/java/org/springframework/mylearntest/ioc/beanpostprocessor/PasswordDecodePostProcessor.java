package org.springframework.mylearntest.ioc.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PasswordDecodePostProcessor implements BeanPostProcessor {
	public Object postProcessAfterInitialization(Object object, String beanName)
			throws BeansException {
		return object;
	}
	public Object postProcessBeforeInitialization(Object object, String beanName)
			throws BeansException {
		if(object instanceof PasswordDecodable){
			String encodedPassword = ((PasswordDecodable)object).getEncodedPassword();
			String decodedPassword = decodePassword(encodedPassword);
			((PasswordDecodable)object).setDecodedPassword(decodedPassword);
		}
		return object;
	}
	private String decodePassword(String encodedPassword) {
		// 实现解码逻辑
		encodedPassword = encodedPassword + "2mingwen";
		return encodedPassword;
	}
}