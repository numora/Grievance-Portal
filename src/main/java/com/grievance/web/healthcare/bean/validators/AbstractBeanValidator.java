package com.grievance.web.healthcare.bean.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.grievance.web.healthcare.common.validation.ValidationUtilities;

public abstract class AbstractBeanValidator implements Validator {

	protected int errorCount = 0;

	protected ValidationUtilities validationUtilities;

	protected Object getTarget(BindingResult result) {
		return result.getTarget();
	}

	@Autowired
	public void setValidationUtilities(ValidationUtilities validationUtilities) {
		this.validationUtilities = validationUtilities;
	}

	protected void resetErrorCount(Errors errors) {
		errorCount = errors.getErrorCount();
	}

	public int getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}

	public void validate(Object object, Errors errors) {
		validate(object, errors, false);
	}

	public void validate(Object object, Errors errors,
			boolean ignoreNestedObjectRules) {

		int initialErrorCount = errors.getErrorCount();

		// Validate Required Rules on the Fields that are Mandatory
		validateRequiredRules(object, errors);

		// If Required Fields are Missing we don't want to Perform other
		// Validations on the Same Object
		if (errors.getErrorCount() == initialErrorCount) {
			validateOtherRules(object, errors);
		}

		// Validate Nested Object Rules
		if (!ignoreNestedObjectRules) {
			validateNestedObjectsRules(object, errors);
		}
	}

	protected abstract void validateRequiredRules(Object object, Errors errors);

	protected void validateOtherRules(Object object, Errors errors) {
	}

	protected void validateNestedObjectsRules(Object object, Errors errors) {
	}
}
