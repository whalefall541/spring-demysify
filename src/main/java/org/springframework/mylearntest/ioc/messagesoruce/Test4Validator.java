package org.springframework.mylearntest.ioc.messagesoruce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4Validator {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("messagesource/validator.xml");
		Validator validator = (Validator) context.getBean("validator");
		MessageSource messageSource = validator.getMessageSource();
		System.out.println("messageSource = " + messageSource);
	}
}
