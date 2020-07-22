package org.springframework.mylearntest.aop.pointcut.annotationmatchingpointcut;

@ClassLevelAnnotation
public class GenericTargetObject {

	@MethodLevelAnnotation
	public void getMethod1() {
		System.out.println("getMethod1");
	}

	public void getMethod2() {
		System.out.println("getMethod2");
	}
}
