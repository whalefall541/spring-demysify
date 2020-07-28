package org.springframework.mylearntest.aop1.advice.perinstance;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class TesterFeatureIntroductionInterceptor extends DelegatingIntroductionInterceptor implements ITester {

	public static final long serialVersionUID = -3387097489523045796L;
	private boolean busyAsTester;

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		if (isBusyAsTester() && StringUtils.contains(mi.getMethod().getName(), "developSoftware")) {
			throw new RuntimeException("I'am so tired");
		}
		return super.invoke(mi);
	}

	@Override
	public boolean isBusyAsTester() {
		return busyAsTester;
	}

	public void setBusyAsTester(boolean busyAsTester) {
		this.busyAsTester = busyAsTester;
	}

	@Override
	public void testSoftware() {
		System.out.println("I will ensure the quality");
	}
}
