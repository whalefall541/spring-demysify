package org.springframework.mylearntest.aop2.aopextends;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;


/**
 * @Author: WhaleFall541
 * @Date: 2020/8/14 0:10
 */
@Aspect
public class PerformanceTraceAspect1 {
    private final Log logger = LogFactory.getLog(PerformanceTraceAspect1.class);

    @Pointcut("execution(public void *.method1())")
    public void method1() {}

    @Pointcut("execution(public void *.method2())")
    public void method2() {}

    @Pointcut("method1() || method2()")
    public void compositePointcut() {}

    @Around("compositePointcut()")
    public Object performanceTrace(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch watch = new StopWatch();
        try {
            watch.start();
            return pjp.proceed();
        } finally {
            watch.stop();
            System.out.println("PT in method" + pjp.getSignature().getName() + "]>>>>>" + watch.toString());
            if (logger.isInfoEnabled()) {
                logger.info("PT in method" + pjp.getSignature().getName() + "]>>>>>" + watch.toString());
            }
        }
    }
}
