package org.springframework.mylearntest.aop1.advice.perclass;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PerformanceMethodInterceptor implements MethodInterceptor {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		StopWatch watch = new StopWatch();
		try {
			watch.start();
			System.out.println("this is in advice");
			return invocation.proceed();
		} finally {
			watch.stop();
			if (logger.isInfoEnabled()) {
				logger.info(watch.toString());
			}
		}
	}
}
