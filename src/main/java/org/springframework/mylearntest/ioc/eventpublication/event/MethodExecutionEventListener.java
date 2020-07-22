package org.springframework.mylearntest.ioc.eventpublication.event;


import java.util.EventListener;

/**
 * 自定义事件监听器
 */
public interface MethodExecutionEventListener extends EventListener {
	/**
	 * 处理方法开始执行的时候发布的MethodExecutionEvent事件
	 */
	void onMethodBegin(MethodExecutionEvent evt);
	/**
	 * 处理方法执行将结束时候发布的MethodExecutionEvent事件
	 */
	void onMethodEnd(MethodExecutionEvent evt);
}
