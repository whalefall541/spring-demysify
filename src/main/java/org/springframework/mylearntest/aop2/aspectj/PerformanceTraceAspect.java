package org.springframework.mylearntest.aop2.aspectj;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author: whalefall
 * @Date: 2020/7/28 22:46
 * Spring 2.0 之后无需实现接口定义pointcut
 */
@Aspect
public class PerformanceTraceAspect {
	private final Log logger = LogFactory.getLog(PerformanceTraceAspect.class);

	@Pointcut
	public void pointcutName() {}

	@Around("pointcutName()")
	public Object performanceTrace(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch sw = new StopWatch();
		try {
			sw.start();
			return joinPoint.proceed();
		} finally {
			if (logger.isInfoEnabled())
				logger.info("pt in method["
						+ joinPoint.getSignature().getName()
				+ "]>>>>>>" + sw.toString());
		}
	}
}
