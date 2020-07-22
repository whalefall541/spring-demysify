package org.springframework.mylearntest.ioc.resourceloader;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ResourceLoader;

/**
 * 容器启动的时候，就会自动将当前ApplicationContext容器本身
 * 注入到FooBar中，因为ApplicationContext类型容器可以自动识别Aware接口
 */
public class FooBarImplApplicationContextAware implements ApplicationContextAware {

	private ResourceLoader resourceLoader;

	public void foo(String location) {
		System.out.println(getResourceLoader().getResource(location).getClass());
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}

	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.resourceLoader = ctx;
	}
}
