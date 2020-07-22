package org.springframework.mylearntest.ioc.directcode;

public interface IFXNewsListener {
	String[] getAvailableNewsIds();

	FXNewsBean getNewsByPK(String newsId);

	void postProcessIfNecessary(String newsId);
}
