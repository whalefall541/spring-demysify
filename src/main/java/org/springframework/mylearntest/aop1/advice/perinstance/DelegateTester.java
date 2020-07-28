package org.springframework.mylearntest.aop1.advice.perinstance;

import org.springframework.aop.support.DelegatePerTargetObjectIntroductionInterceptor;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class DelegateTester {
	public static void main(String[] args) {
		ITester delegator = new Tester();
		DelegatingIntroductionInterceptor interceptor = new DelegatingIntroductionInterceptor(delegator);

		// 进行织入
		/*ITester tester = (ITester)weaver.weave(developer).with(interceptor).getProxy();
		tester.testSoftware();*/

		DelegatePerTargetObjectIntroductionInterceptor interceptor1 =
				new DelegatePerTargetObjectIntroductionInterceptor(Tester.class,ITester.class);
	}
}
