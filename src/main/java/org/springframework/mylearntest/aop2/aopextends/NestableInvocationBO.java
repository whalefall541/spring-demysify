package org.springframework.mylearntest.aop2.aopextends;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/14 0:03
 * 统一对象内方法嵌套调用的目标对象示例
 */
public class NestableInvocationBO {
    public void method1() {
        method2();
        System.out.println("method1 executed");
    }

    public void method2() {
        System.out.println("method2 executed");
    }
}
