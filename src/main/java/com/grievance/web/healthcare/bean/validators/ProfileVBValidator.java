package com.grievance.web.healthcare.bean.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.grievance.web.healthcare.common.validation.ValidationUtilities;
import com.grievance.web.healthcare.viewbean.ProfileVB;
import com.grievance.web.healthcare.viewbean.SignInVB;

@Component
public class ProfileVBValidator extends AbstractVBValidator {

	public boolean supports(Class<?> clazz) {
		return SignInVB.class.isAssignableFrom(clazz);
	}

	protected ValidationUtilities validationUtilities;

	@Autowired
	public void setValidationUtilities(ValidationUtilities validationUtilities) {
		this.validationUtilities = validationUtilities;
	}

	@Override
	public void validateVB(Object object, Errors errors) {
		if (object instanceof ProfileVB) {
			ProfileVB profileVB = (ProfileVB) object;
			validate(profileVB, errors);
		}
	}

	protected void validate(ProfileVB profileVB, Errors errors) {

		if (profileVB == null) {
			return;
		}

		int initialErrorCount = errors.getErrorCount();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","email.required");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","password.required");

		if (errors.getErrorCount() == initialErrorCount) {
			// validateOtherRules(signInVB, errors, initialErrorCount);
		}

	}

	private void validateOtherRules(SignInVB signInVB, Errors errors,int initialErrorCount) {

		validationUtilities.rejectIfNotEmail(errors, "email", "invalid");

		validationUtilities.rejectIfNotPassword(errors, "password", "invalid");
		
	}

}
