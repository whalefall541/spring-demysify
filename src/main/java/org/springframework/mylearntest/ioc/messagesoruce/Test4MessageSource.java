package org.springframework.mylearntest.ioc.messagesoruce;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.context.support.StaticMessageSource;

import java.util.Locale;

import static junit.framework.TestCase.assertEquals;

public class Test4MessageSource {
	public static void main(String[] args) {
		// StaticMessageSource
		StaticMessageSource messageSource = new StaticMessageSource();
		messageSource.addMessage("menu.file", Locale.US, "File");
		messageSource.addMessage("menu.edit", Locale.US, "Edit");
		assertEquals("File", messageSource.getMessage("menu.file", new Object[]{"F"}, Locale.US));
		assertEquals("Edit", messageSource.getMessage("menu.edit", null,"Edit", Locale.US));

		// ResourceBundleMessageSource
		ResourceBundleMessageSource messageSource1 = new ResourceBundleMessageSource();
		messageSource1.setBasenames(new String[]{"conf/messages"});// 从 classpath加载资源文件
		assertEquals("File(F)", messageSource.getMessage("menu.file", new Object[]{"F"}, Locale.US));

		// ReloadableResourceBundleMessageSource
		/*ReloadableResourceBundleMessageSource messageSource2 = new ReloadableResourceBundleMessageSource();
		messageSource2.setBasenames(new String[]{"file:conf/messages"}); // 从文件系统加载资源文件
		assertEquals("File(F)", messageSource.getMessage("menu.file", new Object[]{"F"}, Locale.US));*/
	}
}
