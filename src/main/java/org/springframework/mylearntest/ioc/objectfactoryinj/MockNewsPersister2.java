package org.springframework.mylearntest.ioc.objectfactoryinj;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.mylearntest.ioc.directcode.FXNewsBean;
import org.springframework.mylearntest.ioc.directcode.IFXNewsPersister;

@SuppressWarnings({"rawtypes" })
public class MockNewsPersister2 implements IFXNewsPersister {
	private ObjectFactory newsBeanFactory;
	public void persistNews(FXNewsBean bean) {
		persistNews();
	}
	public void persistNews() {
		System.out.println("persist bean:"+getNewsBean());
	}
	public FXNewsBean getNewsBean() {
		return (FXNewsBean) newsBeanFactory.getObject();
	}
	public void setNewsBeanFactory(ObjectFactory newsBeanFactory) {
		this.newsBeanFactory = newsBeanFactory;
	}
}