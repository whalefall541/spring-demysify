package org.springframework.mylearntest.ioc.annotationautowired;

import org.springframework.mylearntest.ioc.directcode.FXNewsBean;
import org.springframework.mylearntest.ioc.directcode.IFXNewsListener;
import org.springframework.stereotype.Component;

@Component("djNewsListener")
public class DowJonesNewsListener implements IFXNewsListener{
	@Override
	public String[] getAvailableNewsIds() {
		return new String[0];
	}

	@Override
	public FXNewsBean getNewsByPK(String newsId) {
		return null;
	}

	@Override
	public void postProcessIfNecessary(String newsId) {

	}
}