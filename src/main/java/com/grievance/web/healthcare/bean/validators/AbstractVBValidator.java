package com.grievance.web.healthcare.bean.validators;

import org.springframework.validation.Errors;

import com.grievance.web.healthcare.viewbean.BaseVB;

public abstract class AbstractVBValidator {

	protected void validateVB(Object object, Errors errors) {
		BaseVB baseVB = (BaseVB) object;
		this.validatePortalVB(baseVB, errors);
	}

	protected abstract void validatePortalVB(BaseVB baseVB, Errors errors);

}
