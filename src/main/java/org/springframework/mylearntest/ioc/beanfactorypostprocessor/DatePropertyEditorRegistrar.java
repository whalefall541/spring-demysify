package org.springframework.mylearntest.ioc.beanfactorypostprocessor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.beans.PropertyEditor;

public class DatePropertyEditorRegistrar implements PropertyEditorRegistrar {
	private PropertyEditor propertyEditor;

	public PropertyEditor getPropertyEditor() {
		return propertyEditor;
	}

	public void setPropertyEditor(PropertyEditor propertyEditor) {
		this.propertyEditor = propertyEditor;
	}

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(java.util.Date.class,getPropertyEditor());
	}
}
