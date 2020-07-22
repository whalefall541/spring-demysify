package org.springframework.mylearntest.ioc.resourceloader;

import org.springframework.core.io.*;
import static junit.framework.TestCase.assertTrue;


public class Test4ResourceLoader2 {
	public static void main(String[] args) {
		// FileSystemResourceLoader
		ResourceLoader resourceLoader = new FileSystemResourceLoader();
		Resource fileResource = resourceLoader.getResource("D:/spring21site/README");
		assertTrue(fileResource instanceof FileSystemResource);
		assertTrue(fileResource.exists());
		Resource urlResource = resourceLoader.getResource("file:D:/spring21site/README");
		assertTrue(urlResource instanceof UrlResource);
	}

}
