package org.springframework.mylearntest.ioc.initmetod;

import net.objectlab.kit.datecalc.joda.LocalDateCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4InitMethod {
	public static void main(String[] args) {
		// todo fix the exception
		// Caused by: org.springframework.jdbc.UncategorizedSQLException: SqlMapClient operation; uncategorized SQLException; SQL state [null]; error code [0];
		ApplicationContext context = new ClassPathXmlApplicationContext("initmethod/initmethod.xml");
		FXTradeDateCalculator tradeDateCalculator = (FXTradeDateCalculator) context.getBean("FXTradeDateCalculator");
		LocalDateCalculator forwardDateCalculator = tradeDateCalculator.getForwardDateCalculator();
		System.out.println("forwardDateCalculator = " + forwardDateCalculator);
	}
}
