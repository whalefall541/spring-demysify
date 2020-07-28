package org.springframework.mylearntest.aop1.advisor;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4DefaultIntroductionAdvisor {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("advisor\\defaultintroductionadvisor\\defaultintroductionadvisor.xml");
		IntroductionAdvisor introductionAdvisor = (IntroductionAdvisor) context.getBean("introductionAdvisor");
		System.out.println("introductionAdvisor = " + introductionAdvisor);
	}
}
