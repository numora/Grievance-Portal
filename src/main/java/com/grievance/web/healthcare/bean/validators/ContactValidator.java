package com.grievance.web.healthcare.bean.validators;

import org.springframework.validation.Errors;

public class ContactValidator extends AbstractBeanValidator {

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	protected void validateRequiredRules(Object object, Errors errors) {
		
	}

}
