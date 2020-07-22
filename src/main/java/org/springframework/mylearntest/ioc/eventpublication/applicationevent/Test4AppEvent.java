package org.springframework.mylearntest.ioc.eventpublication.applicationevent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4AppEvent {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("eventpublication/applicationevent.xml");
		MethodExeuctionEventPublisher evtPublisher = (MethodExeuctionEventPublisher) context.getBean("evtPublisher");
		evtPublisher.methodToMonitor();
	}
}
