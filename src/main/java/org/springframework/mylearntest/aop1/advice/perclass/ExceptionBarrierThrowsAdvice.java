package org.springframework.mylearntest.aop1.advice.perclass;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class ExceptionBarrierThrowsAdvice implements ThrowsAdvice {
	public void afterThrowing(Throwable t) {
		// 普通异常处理
	}

	public void afterThrowing(RuntimeException t) {
		// 运行时异常处理
	}

	public void afterThrowing(Method m, Object[] args, Object target, ApplicationException e) {
		// 处理应用程序生成的异常
	}
}
