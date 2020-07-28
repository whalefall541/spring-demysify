package org.springframework.mylearntest.aop1.advisor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mylearntest.aop1.advice.perclass.DiscountMethodInterceptor;

public class Test4NameMatchMethodPointcutAdvisor {
	public static void main(String[] args) {
		Advice advice = new DiscountMethodInterceptor();
		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(advice);
		advisor.setMappedName("invoke");
		System.out.println("advisor = " + advisor);
		// advisor.setMappedNames(new String[]{"invoke", "setCampaignAvailable"});

		ApplicationContext context = new ClassPathXmlApplicationContext("advisor\\namematchmethodpointcutadvisor\\namematchmethodpointcutadvisor.xml");
		Advisor advisor1 = (Advisor) context.getBean("advisor");
		System.out.println("advisor1 = " + advisor1);
	}
}
