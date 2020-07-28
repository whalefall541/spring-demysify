package org.springframework.mylearntest.aop1.advisor;

import org.springframework.aop.Advisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4DefaultAdvisor {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("advisor\\defaultadvisor\\defaultadvisor.xml");
		Advisor advisor = (Advisor) context.getBean("advisor");
		System.out.println("advisor.toString() = " + advisor.toString());
	}
}
