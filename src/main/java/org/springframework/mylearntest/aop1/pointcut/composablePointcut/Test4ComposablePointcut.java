package org.springframework.mylearntest.aop1.pointcut.composablePointcut;

import org.junit.Assert;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.Pointcuts;

public class Test4ComposablePointcut {

	public static void main(String[] args) {
		ComposablePointcut pointcut1 = new ComposablePointcut(new ClassFilter() {
			@Override
			public boolean matches(Class<?> clazz) {
				return false;
			}
		}, MethodMatcher.TRUE);

		ComposablePointcut pointcut2 = new ComposablePointcut(new ClassFilter() {
			@Override
			public boolean matches(Class<?> clazz) {
				return false;
			}
		}, MethodMatcher.TRUE);

		// union intersection
		ComposablePointcut union = pointcut1.union(pointcut2);
		ComposablePointcut intersection = pointcut1.intersection(union);

		Assert.assertEquals(pointcut1,intersection);

		// combine classFilter with methodMatcher
		pointcut2.union(new ClassFilter() {
			@Override
			public boolean matches(Class<?> clazz) {
				return false;
			}
		}).intersection(MethodMatcher.TRUE);

		// just compute between pointcut, use org.springframework.aop.support.Pointcuts
		Pointcut pointcut3 = new Pointcut() {
			@Override
			public ClassFilter getClassFilter() {
				return null;
			}

			@Override
			public MethodMatcher getMethodMatcher() {
				return null;
			}
		};

		Pointcut pointcut4 = new Pointcut() {
			@Override
			public ClassFilter getClassFilter() {
				return null;
			}

			@Override
			public MethodMatcher getMethodMatcher() {
				return null;
			}
		};

		Pointcut union1 = Pointcuts.union(pointcut3, pointcut4);
		Pointcut intersection1 = Pointcuts.intersection(pointcut3, pointcut4);

	}
}
