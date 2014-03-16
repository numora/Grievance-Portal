package com.grievance.web.healthcare.bean.validators;

import org.springframework.validation.Errors;

public abstract class AbstractHealthCareValidator {

	protected void validateVB(Object object, Errors errors) {

		this.validateHealthCareVB(object, errors);
	}

	protected abstract void validateHealthCareVB(Object object, Errors errors);

}
