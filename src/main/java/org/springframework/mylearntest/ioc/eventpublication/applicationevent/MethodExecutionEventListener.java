package org.springframework.mylearntest.ioc.eventpublication.applicationevent;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@SuppressWarnings("rawtypes")
public class MethodExecutionEventListener implements ApplicationListener {
	public void onApplicationEvent(ApplicationEvent evt) {
		if (evt instanceof MethodExecutionEvent) {
			// 执行处理逻辑
		}
	}
}
