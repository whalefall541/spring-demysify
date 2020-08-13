package org.springframework.mylearntest.aop2.aopextends;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/14 0:24
 */
public class Test4NestableInvocationBO {
    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory(new NestableInvocationBO());
        weaver.setProxyTargetClass(true);
        // 要使AopContext.currentProxy()生效 需要设置exposeProxy属性为true
        weaver.setExposeProxy(true);
        weaver.addAspect(PerformanceTraceAspect1.class);
        Object proxy = weaver.getProxy();
        ((NestableInvocationBO)proxy).method2();
        ((NestableInvocationBO)proxy).method1();
    }

}
