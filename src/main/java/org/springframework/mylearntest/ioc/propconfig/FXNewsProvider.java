package org.springframework.mylearntest.ioc.propconfig;

public class FXNewsProvider {
	private DjNewsListener djNewsListener;
	private DjNewsPersister djNewsPersister;

	public DjNewsListener getDjNewsListener() {
		return djNewsListener;
	}

	public void setDjNewsListener(DjNewsListener djNewsListener) {
		this.djNewsListener = djNewsListener;
	}

	public DjNewsPersister getDjNewsPersister() {
		return djNewsPersister;
	}

	public void setDjNewsPersister(DjNewsPersister djNewsPersister) {
		this.djNewsPersister = djNewsPersister;
	}

	public FXNewsProvider() {
	}

	public FXNewsProvider(DjNewsListener djNewsListener, DjNewsPersister djNewsPersister) {
		this.djNewsListener = djNewsListener;
		this.djNewsPersister = djNewsPersister;
	}

	public void getAndPersistNews() {
		System.out.println("-------get----------and----------persist----------news-------- ");
	}
}
