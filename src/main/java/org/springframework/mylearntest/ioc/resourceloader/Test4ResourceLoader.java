package org.springframework.mylearntest.ioc.resourceloader;

import org.springframework.core.io.*;

import java.io.IOException;

import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.util.AssertionErrors.fail;
import static org.testng.Assert.assertFalse;

public class Test4ResourceLoader {
	public static void main(String[] args) {
		// defaultResourceLoader
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource fakeFileResource = resourceLoader.getResource("D:/spring21site/README");
		assertTrue(fakeFileResource instanceof ClassPathResource);
		assertFalse(fakeFileResource.exists());
		Resource urlResource1 = resourceLoader.getResource("file:D:/spring21site/README");
		assertTrue(urlResource1 instanceof UrlResource);
		Resource urlResource2 = resourceLoader.getResource("http://www.spring21.cn");
		assertTrue(urlResource2 instanceof UrlResource);

		try{
			fakeFileResource.getFile();
			fail("no such file with path["+fakeFileResource.getFilename()+"] exists in classpath");
		}
		 catch (IOException e) {
			e.printStackTrace();
		}

		try{
			urlResource1.getFile();
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
	}

}
