package org.springframework.mylearntest.aop2.aspectj;

import org.apache.commons.io.FileUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.io.Resource;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/13 1:21
 */
@Aspect
public class ResourceSetupAspectJ {
    private Resource resource;

    @Pointcut("execution(boolean *.execute())")
    private void resourceSetupJoinpoint() {
    }

    @Before("resourceSetupJoinpoint()")
    public void setupResourcesBefore() throws Throwable {
        if (!getResource().exists())
            FileUtils.forceMkdir(getResource().getFile());
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
