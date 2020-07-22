package org.springframework.mylearntest.ioc.annotationfactory;

public class AnyFactory {
	@FactoryMethod
	public <T> T create(Class<T> clazz) {
	// 创建并返回相应的实例
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
	//...
			return null;
		} catch (IllegalAccessException e) {
	//...
			return null;
		}
	}
}
