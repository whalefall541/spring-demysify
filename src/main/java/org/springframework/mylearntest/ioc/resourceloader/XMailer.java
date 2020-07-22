package org.springframework.mylearntest.ioc.resourceloader;

import org.springframework.core.io.Resource;

import java.util.Map;

@SuppressWarnings("rawtypes")
public class XMailer {
	private Resource template;

	public Resource getTemplate() {
		return template;
	}

	public void setTemplate(Resource template) {
		this.template = template;
	}

	public void sendMail(Map mailCtx) {
		// String mailContext = merge(getTemplate().getInputStream(),mailCtx);
		//...
	}

	@Override
	public String toString() {
		return "XMailer{" +
				"template=" + template +
				'}';
	}
}