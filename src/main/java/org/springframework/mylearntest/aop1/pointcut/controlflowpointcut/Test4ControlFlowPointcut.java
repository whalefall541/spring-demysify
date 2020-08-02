package org.springframework.mylearntest.aop1.pointcut.controlflowpointcut;

import org.springframework.aop.support.ControlFlowPointcut;

public class Test4ControlFlowPointcut {

	public static void main(String[] args) {
		ControlFlowPointcut pointcut1 = new ControlFlowPointcut(TargetCaller.class,"callMethod");
		ControlFlowPointcut pointcut = new ControlFlowPointcut(TargetCaller.class);
		TargetObject target = new TargetObject();

		/*ProxyFactory weaver = new ProxyFactory();
		TargetObject targetObject2use = weaver.weave(advice).to(target).accordingto(pointcut);
		// advice的逻辑在这里不会被触发执行
		targetObject2use.method1();

		// advice的逻辑在这里会被触发执行
		TargetCaller caller = new TargetCaller();
		caller.setTarget(targetObject2use);*/
	}
}
