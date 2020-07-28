package org.springframework.mylearntest.aop1.weaver.introduction;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.mylearntest.aop1.advice.perinstance.Developer;
import org.springframework.mylearntest.aop1.advice.perinstance.IDeveloper;
import org.springframework.mylearntest.aop1.advice.perinstance.ITester;
import org.springframework.mylearntest.aop1.advice.perinstance.TesterFeatureIntroductionInterceptor;

/**
 * @Author: whalefall
 * @Date: 2020/7/19 0:02
 */

@SuppressWarnings("rawtypes")
public class Test4Introduction {
	public static void main(String[] args) {
		ProxyFactory weaver = new ProxyFactory(new Developer());
		weaver.setInterfaces(new Class[]{IDeveloper.class, ITester.class});
		TesterFeatureIntroductionInterceptor advice = new TesterFeatureIntroductionInterceptor();
		weaver.addAdvice(advice);
		// DefaultIntroductionAdvisor advisor = new DefaultIntroductionAdvisor(advice,advice);
		// weaver.addAdvisor(advisor);

		Object proxy = weaver.getProxy();
		((ITester)proxy).testSoftware();
		((IDeveloper)proxy).developSoftware();
		System.out.println("proxy = " + proxy);

	}
}
