package org.springframework.mylearntest.ioc.beanfactorypostprocessor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePropertyEditor extends PropertyEditorSupport {
	private String datePattern;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(getDatePattern());
		LocalDate dateValue = LocalDate.parse(text,dateTimeFormatter);
		System.err.println(dateValue);
		setValue(dateValue);
	}

	@Override
	public String getAsText() {
		return super.getAsText();
	}

	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
}
