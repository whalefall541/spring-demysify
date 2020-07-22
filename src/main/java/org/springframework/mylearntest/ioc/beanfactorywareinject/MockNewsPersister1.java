package org.springframework.mylearntest.ioc.beanfactorywareinject;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.mylearntest.ioc.directcode.FXNewsBean;
import org.springframework.mylearntest.ioc.directcode.IFXNewsPersister;

public class MockNewsPersister1 implements IFXNewsPersister, BeanFactoryAware {
	private BeanFactory beanFactory;

	public void setBeanFactory(BeanFactory bf) throws BeansException {
		this.beanFactory = bf;
	}

	public void persistNews(FXNewsBean bean) {
		persistNews();
	}

	public void persistNews() {
		System.out.println("persist bean:" + getNewsBean());
	}

	public FXNewsBean getNewsBean() {
		return (FXNewsBean) beanFactory.getBean("newsBean");
	}
}