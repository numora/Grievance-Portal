package com.grievance.web.healthcare.bean.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.grievance.web.healthcare.common.validation.ValidationUtilities;
import com.grievance.web.healthcare.viewbean.BaseVB;
import com.grievance.web.healthcare.viewbean.SignInVB;

@Component
public class SignInVBValidator extends AbstractVBValidator {

	public boolean supports(Class<?> clazz) {
		return SignInVB.class.isAssignableFrom(clazz);
	}
	
	protected ValidationUtilities validationUtilities;

	@Autowired
	public void setValidationUtilities(ValidationUtilities validationUtilities) {
		this.validationUtilities = validationUtilities;
	}

	@Override
	public void validatePortalVB(BaseVB baseVB, Errors errors) {
		if (baseVB instanceof SignInVB) {
			SignInVB signInVB = (SignInVB) baseVB;
			validate(signInVB, errors);
		}
	}

	protected void validate(SignInVB signInVB, Errors errors) {

		if (signInVB == null) {
			return;
		}

		int initialErrorCount = errors.getErrorCount();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginName", "loginName.required");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","password.required");
		
		// If email and password not empty then check for other validations
		if (errors.getErrorCount() == initialErrorCount) {
			// validateOtherRules(signInVB, errors, initialErrorCount);
		}

	}

	private void validateOtherRules(SignInVB signInVB, Errors errors,
			int initialErrorCount) {
		
		validationUtilities.rejectIfNotEmail(errors, "email", "invalid");

		validationUtilities.rejectIfNotPassword(errors, "password", "invalid");

		if (errors.getErrorCount() == initialErrorCount) {

			if (signInVB.getPassword().length() < 5) {
				errors.rejectValue("password", "invalidMinLength", null, null);
			} else if (signInVB.getPassword().length() > 16) {
				errors.rejectValue("password", "invalidMaxLength", null, null);
			}

			if (errors.getErrorCount() == initialErrorCount) {
				validationUtilities.rejectIfSimilar(errors, "email","password", "similar");
			}
		}
	}

	

}
