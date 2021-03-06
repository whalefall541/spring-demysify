package org.springframework.mylearntest.aop1.advice.perclass;

import org.apache.commons.io.FileUtils;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.core.io.Resource;

import java.lang.reflect.Method;

public class ResourceSetupBeforeAdvice implements MethodBeforeAdvice {
	private Resource resource;

	public ResourceSetupBeforeAdvice(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		if (!resource.exists()) {
			FileUtils.forceMkdir(resource.getFile());
		}
	}
}
