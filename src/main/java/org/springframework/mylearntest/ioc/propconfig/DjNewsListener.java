package org.springframework.mylearntest.ioc.propconfig;

import org.springframework.mylearntest.ioc.directcode.FXNewsBean;
import org.springframework.mylearntest.ioc.directcode.IFXNewsListener;

public class DjNewsListener implements IFXNewsListener {

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


