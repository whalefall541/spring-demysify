package org.springframework.mylearntest.ioc.eventpublication.event;

import java.util.ArrayList;
import java.util.List;

public class MethodExeuctionEventPublisher {
	private List<MethodExecutionEventListener> listeners = new
			ArrayList<MethodExecutionEventListener>();

	public void methodToMonitor() {
		MethodExecutionEvent event2Publish =
				new MethodExecutionEvent(this, "methodToMonitor");
		publishEvent(MethodExecutionStatus.BEGIN, event2Publish);
		// 执行实际的方法逻辑
		// ...
		publishEvent(MethodExecutionStatus.END, event2Publish);
	}

	// 为了避免事件处理期间事件监听器的注册或移除操作影响处理过程，我们对事件发布时点的监听器列表进行了一个安全复制（ safe-copy）
	protected void publishEvent(MethodExecutionStatus status,
								MethodExecutionEvent methodExecutionEvent) {
		List<MethodExecutionEventListener> copyListeners =
				new ArrayList<MethodExecutionEventListener>(listeners);
		for (MethodExecutionEventListener listener : copyListeners) {
			if (MethodExecutionStatus.BEGIN.equals(status))
				listener.onMethodBegin(methodExecutionEvent);
			else
				listener.onMethodEnd(methodExecutionEvent);
		}
	}

	public void addMethodExecutionEventListener(MethodExecutionEventListener listener) {
		this.listeners.add(listener);
	}

	public void removeListener(MethodExecutionEventListener listener) {
		if (this.listeners.contains(listener))
			this.listeners.remove(listener);
	}

	public void removeAllListeners() {
		this.listeners.clear();
	}

}