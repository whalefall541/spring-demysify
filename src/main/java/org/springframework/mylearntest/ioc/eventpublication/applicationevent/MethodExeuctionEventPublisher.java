package org.springframework.mylearntest.ioc.eventpublication.applicationevent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.mylearntest.ioc.eventpublication.event.MethodExecutionStatus;

public class MethodExeuctionEventPublisher implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher eventPublisher;

	public void methodToMonitor() {
		MethodExecutionEvent beginEvt = new
				MethodExecutionEvent(this, "methodToMonitor", MethodExecutionStatus.BEGIN);
		this.eventPublisher.publishEvent(beginEvt);
		// 执行实际方法逻辑
		// ...
		MethodExecutionEvent endEvt = new
				MethodExecutionEvent(this, "methodToMonitor", MethodExecutionStatus.END);
		this.eventPublisher.publishEvent(endEvt);
	}

	public void setApplicationEventPublisher(ApplicationEventPublisher appCtx) {
		this.eventPublisher = appCtx;
	}
}
