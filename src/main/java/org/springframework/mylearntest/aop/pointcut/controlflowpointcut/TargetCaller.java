package org.springframework.mylearntest.aop.pointcut.controlflowpointcut;

public class TargetCaller {
	private TargetObject target;

	public void callMethod() {
		target.method1();
	}

	public void setTarget(TargetObject target) {
		this.target = target;
	}
}
