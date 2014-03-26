package com.grievance.web.healthcare.bean.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component("contactValidator")
public class ContactValidator extends AbstractBeanValidator {

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	protected void validateRequiredRules(Object object, Errors errors) {
		
	}

}
