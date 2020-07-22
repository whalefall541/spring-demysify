package org.springframework.mylearntest.ioc.annotationautowired;

import org.springframework.mylearntest.ioc.directcode.FXNewsBean;
import org.springframework.mylearntest.ioc.directcode.IFXNewsPersister;
import org.springframework.stereotype.Component;

@Component
public class DowJonesNewsPersister implements IFXNewsPersister {

	@Override
	public void persistNews(FXNewsBean newsBean) {

	}
}
