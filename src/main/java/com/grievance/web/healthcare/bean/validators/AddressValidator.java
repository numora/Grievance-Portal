package com.grievance.web.healthcare.bean.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component("addressValidator")
public class AddressValidator extends AbstractBeanValidator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void validateRequiredRules(Object object, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
