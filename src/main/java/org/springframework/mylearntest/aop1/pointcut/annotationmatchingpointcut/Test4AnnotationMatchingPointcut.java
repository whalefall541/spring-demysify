package org.springframework.mylearntest.aop1.pointcut.annotationmatchingpointcut;

import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class Test4AnnotationMatchingPointcut {
	AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(ClassLevelAnnotation.class);
	// 也可以通过静态方法
	AnnotationMatchingPointcut pointcut1 = AnnotationMatchingPointcut.forClassAnnotation(MethodLevelAnnotation.class);
	// 同时限定
	AnnotationMatchingPointcut pointcut2 = AnnotationMatchingPointcut.forClassAnnotation(ClassLevelAnnotation.class);


}
