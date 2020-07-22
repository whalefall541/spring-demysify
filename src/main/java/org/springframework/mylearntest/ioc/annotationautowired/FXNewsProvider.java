package org.springframework.mylearntest.ioc.annotationautowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mylearntest.ioc.directcode.IFXNewsListener;
import org.springframework.mylearntest.ioc.directcode.IFXNewsPersister;
import org.springframework.stereotype.Component;

@Component
public class FXNewsProvider {

	@Autowired
	private IFXNewsListener newsListener;
	@Autowired
	private IFXNewsPersister newPersistener;

	public void getAndPersistNews() {
		System.out.println("-------get----------and----------persist----------news-------- ");
	}
}