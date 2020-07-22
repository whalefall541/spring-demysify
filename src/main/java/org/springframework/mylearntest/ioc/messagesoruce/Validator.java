package org.springframework.mylearntest.ioc.messagesoruce;

import org.springframework.context.MessageSource;

import java.lang.reflect.InvocationTargetException;

public class Validator {
	private MessageSource messageSource;

	public ValidateResult validate(Object target) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		// 执行相应验证逻辑
		if (target == null) {
			throw new RuntimeException("param target is null, plz check");
		}

		// 如果有错误，通过messageSource.getMessage(...)获取相应信息并放入验证结果对象中
		// 返回验证结果（ return result）
		return ValidateResult.getInstance4Message();
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource msgSource) {
		this.messageSource = msgSource;
	}

	// ...
}
