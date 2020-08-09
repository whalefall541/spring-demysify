package org.springframework.mylearntest.aop2.introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.mylearntest.aop1.weaver.proxyfactorybean.CounterImpl;
import org.springframework.mylearntest.aop1.weaver.proxyfactorybean.ICounter;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/9 16:50
 * 将ICounter行为introduce附加到ITask之上
 */
@Aspect
public class IntroductionAspect {
	// value属性指定将要应用到的一个对象，也可以某个包下所有类value="cn.spring21.unveilspring.service.*"
	// 通过defaultImpl指定新增加的接口定义的实现类，在这里ICounter的实现类为org.springframework.mylearntest.aop1.weaver.proxyfactorybean.CounterImpl
	@DeclareParents(value = "org.springframework.mylearntest.aop1.weaver.baseoninterface.MockTask", defaultImpl =
			CounterImpl.class)
	public ICounter counter;// ICounter即为将要为目标对象鞥家的对象类型
}
