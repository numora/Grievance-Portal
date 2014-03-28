package com.grievance.web.healthcare.bean.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.grievance.web.healthcare.beans.common.Address;
import com.grievance.web.healthcare.beans.common.Profile;
import com.grievance.web.healthcare.common.validation.ValidationUtilities;
import com.grievance.web.healthcare.controller.ProfileController;
import com.grievance.web.healthcare.viewbean.BaseVB;
import com.grievance.web.healthcare.viewbean.ProfileVB;
import com.grievance.web.healthcare.viewbean.SignInVB;

@Component
public class ProfileVBValidator extends AbstractVBValidator {

	static final Logger logger = LoggerFactory.getLogger(ProfileVBValidator.class);

	public boolean supports(Class<?> clazz) {
		return ProfileVB.class.isAssignableFrom(clazz);
	}
	
	private AddressValidator addressValidator;
	
	private ContactValidator contactValidator;
	
	protected ValidationUtilities validationUtilities;
	
	@Autowired
	public void setAddressValidator(AddressValidator addressValidator) {
		this.addressValidator = addressValidator;
	}
	
	@Autowired
	public void setContactValidator(ContactValidator contactValidator) {
	        this.contactValidator = contactValidator;
	}

	@Autowired
	public void setValidationUtilities(ValidationUtilities validationUtilities) {
		this.validationUtilities = validationUtilities;
	}
	
	@Override
	public void validatePortalVB(BaseVB baseVB, Errors errors) {
		if (baseVB instanceof ProfileVB) {
			ProfileVB profileVB = (ProfileVB) baseVB;
			validate(profileVB, errors);
		}
		
	}
	
	protected void validate(ProfileVB profileVB, Errors errors) {
    	
		if (profileVB == null) {
            return;
        }
       
    	validateRequiredRules(profileVB,errors);
		
		// validateOtherRules(profileVB,errors);
		
		//validateNestedObjectsRules(profileVB, errors);
        
    }
	
	protected void validateRequiredRules(ProfileVB profileVB, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","email.required");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","password.required");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","confirmPassword.required");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginName","loginName.required");

	}

	private void validateOtherRules(ProfileVB profileVB, Errors errors) {

		validationUtilities.rejectIfNotEmail(errors, "email", "invalid");
		
		validationUtilities.rejectIfNotPassword(errors, "password", "invalid");

	}
	
	protected void validateNestedObjectsRules(ProfileVB profileVB, Errors errors) {
        if (profileVB != null) {
            Address address = profileVB.getAddress();
            if (address != null) {
                try {
                    errors.pushNestedPath("address");
                    ValidationUtils.invokeValidator((Validator) this.addressValidator, address, errors);
                } finally {
                    errors.popNestedPath();
                }
            }
        }
    }
	
}