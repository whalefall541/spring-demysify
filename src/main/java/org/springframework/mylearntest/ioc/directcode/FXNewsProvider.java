package org.springframework.mylearntest.ioc.directcode;

import org.apache.commons.lang3.ArrayUtils;


public class FXNewsProvider {
	private IFXNewsListener newsListener;
	private IFXNewsPersister newPersistener;
	public FXNewsProvider(IFXNewsListener newsListner,IFXNewsPersister newsPersister) {
		this.newsListener = newsListner;
		this.newPersistener = newsPersister;
	}

	public IFXNewsListener getNewsListener() {
		return newsListener;
	}

	public void setNewsListener(IFXNewsListener newsListener) {
		this.newsListener = newsListener;
	}

	public IFXNewsPersister getNewPersistener() {
		return newPersistener;
	}

	public void setNewPersistener(IFXNewsPersister newPersistener) {
		this.newPersistener = newPersistener;
	}

	public FXNewsProvider() {
	}

	public void getAndPersistNews() {
		String[] newsIds = newsListener.getAvailableNewsIds();
		if (ArrayUtils.isEmpty(newsIds)) {
			System.err.println("newsIds is Empty");
			return;
		}
		for (String newsId : newsIds) {
			FXNewsBean newsBean = newsListener.getNewsByPK(newsId);
			newPersistener.persistNews(newsBean);
			newsListener.postProcessIfNecessary(newsId);
		}
	}
}
