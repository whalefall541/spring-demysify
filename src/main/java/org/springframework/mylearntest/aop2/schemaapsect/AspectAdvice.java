package org.springframework.mylearntest.aop2.schemaapsect;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.util.StopWatch;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/13 20:56
 */
@Aspect
public class AspectAdvice {
    private Resource resource;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @AfterThrowing(pointcut = "execution(boolean *.execute(String, ..))", throwing = "e")
    public void afterThrowing(RuntimeException e) {
        final String exceptionMsg = ExceptionUtils.getStackTrace(e);
        // ...
    }

    @AfterReturning(value = "execution(boolean *.execute(String, ..))",returning = "retValue")
    public void taskExceptionCompleted(JoinPoint jp,boolean retValue) {
        //Class clazz = jp.getTarget().getClass();
        //getSqlMapClientTemplate().insert("BATCH.insertTaskStatus", clazz.getName());
    }

    @After("execution(boolean *.execute(String, ..))")
    public void cleanUpResourcesIfNecessary() throws Throwable {
        if (getResource().exists())
            FileUtils.forceMkdir(getResource().getFile());
    }

    @Around("execution(boolean *.execute(String, ..))")
    public Object performanceTrace(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch watch = new StopWatch();
        try {
            watch.start();
            return pjp.proceed();
        } finally {
            watch.stop();
            System.out.println("watch.toString() = " + watch.toString());
        }
    }
}
