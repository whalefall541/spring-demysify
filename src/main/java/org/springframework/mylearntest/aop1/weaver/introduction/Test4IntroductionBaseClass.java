package org.springframework.mylearntest.aop1.weaver.introduction;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.mylearntest.aop1.advice.perinstance.Developer;
import org.springframework.mylearntest.aop1.advice.perinstance.ITester;
import org.springframework.mylearntest.aop1.advice.perinstance.TesterFeatureIntroductionInterceptor;

/**
 * @Author: whalefall
 * @Date: 2020/7/19 0:27
 */

@SuppressWarnings("rawtypes")
public class Test4IntroductionBaseClass {
	public static void main(String[] args) {
		ProxyFactory weaver = new ProxyFactory(new Developer());
		weaver.setProxyTargetClass(true);
		weaver.setInterfaces(new Class[]{ITester.class});
		TesterFeatureIntroductionInterceptor advice = new TesterFeatureIntroductionInterceptor();
		weaver.addAdvice(advice);
		// DefaultIntroductionAdvisor advisor = new DefaultIntroductionAdvisor(advice,advice);
		// weaver.addAdvisor(advisor);

		Object proxy = weaver.getProxy();
		((ITester)proxy).testSoftware();
		// 注意此处强转为子类
		((Developer)proxy).developSoftware();
		System.out.println("proxy = " + proxy);
	}
}
