package org.springframework.mylearntest.ioc.resourceloader;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class FooBarImplResourceLoader implements ResourceLoaderAware {
	private ResourceLoader resourceLoader;

	public void foo(String location) {
		System.out.println(getResourceLoader().getResource(location).getClass());
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;

	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
}

