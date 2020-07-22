package org.springframework.mylearntest.ioc.eventpublication.event;

/**
 * 自定义事件监听器实现
 */
public class SimpleMethodExecutionEventListener implements MethodExecutionEventListener {

	public void onMethodBegin(MethodExecutionEvent evt) {
		String methodName = evt.getMethodName();
		System.out.println("start to execute the method[" + methodName + "].");
	}

	public void onMethodEnd(MethodExecutionEvent evt) {
		String methodName = evt.getMethodName();
		System.out.println("finished to execute the method[" + methodName + "].");
	}
}
