package org.springframework.mylearntest.aop2.priorityofadvice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/9 18:00
 * 如果将该AspectJ织入目标对象，那么可以得到结果为
 * before one
 * before two
 * after returning two
 * after returning one
 */
@Aspect
public class MultiAdviceAspect {
	@Pointcut("execution(boolean *.execute(String, ..))")
	public void taskExecution(){}

	@Before("taskExecution()")
	public void beforeOne() {
		System.out.println("before one");
	}

	@Before("taskExecution()")
	public void beforeTwo() {
		System.out.println("before two");
	}

	@AfterReturning("taskExecution()")
	public void afterReturningOne() {
		System.out.println("after retuning one");
	}

	@AfterReturning("taskExecution()")
	public void afterReturningTwo() {
		System.out.println("after retuning two");
	}
}
