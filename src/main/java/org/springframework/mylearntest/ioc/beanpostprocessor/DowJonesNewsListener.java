package org.springframework.mylearntest.ioc.beanpostprocessor;

import org.springframework.mylearntest.ioc.directcode.FXNewsBean;
import org.springframework.mylearntest.ioc.directcode.IFXNewsListener;

public class DowJonesNewsListener implements IFXNewsListener,PasswordDecodable {
	private String password;
	public String[] getAvailableNewsIds() {
		// 省略
		return new String[0];
	}
	public FXNewsBean getNewsByPK(String newsId) {
		// 省略
		return null;
	}
	public void postProcessIfNecessary(String newsId) {
		// 省略
	}
	public String getEncodedPassword() {
		return this.password;
	}
	public void setDecodedPassword(String password) {
		this.password = password;
	}
}
