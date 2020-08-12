package org.springframework.mylearntest.aop2.schemaapsect;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/12 21:33
 */
public class SchemaBasedAspect {
	public void method1() {}
	public void method2() {}

	private  final Log logger = LogFactory.getLog(SchemaBasedAspect.class);

	public void doBefore(JoinPoint jp) {
		if (logger.isInfoEnabled()) {
			logger.info("before method {" + jp.getSignature().getName()+"} execution");
		}
	}

	public void doAfterReturning(JoinPoint jp, Object retValue) {
		if (logger.isInfoEnabled()) {
			logger.info("before method {" + jp.getSignature().getName()+"} execution");
			logger.info("with return value: " + retValue);
		}
	}

	public void doAfterThrowing(RuntimeException e) {
		logger.error(ExceptionUtils.getStackTrace(e));
	}

	public void doAfter() {
		logger.warn("release system resources ,etc.");
	}

	// NOTE：第一个参数必须为ProceedingJoinPoint
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch watch = new StopWatch();
		try {
			watch.start();
			return pjp.proceed();
		} finally {
			watch.stop();
			if (logger.isInfoEnabled()) {
				logger.info(watch);
			}
		}
	}
}
