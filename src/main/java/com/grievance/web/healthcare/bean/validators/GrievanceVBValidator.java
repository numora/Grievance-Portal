package com.grievance.web.healthcare.bean.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.grievance.web.healthcare.viewbean.BaseVB;
import com.grievance.web.healthcare.viewbean.GrievanceVB;
@Component
public class GrievanceVBValidator extends AbstractVBValidator {
	
	@Override
	public void validatePortalVB(BaseVB baseVB, Errors errors) {
		if (baseVB instanceof GrievanceVB) {
			GrievanceVB grievanceVB = (GrievanceVB) baseVB;
			validate(grievanceVB, errors);
		}
		
	}
	
	protected void validate(GrievanceVB grievanceVB, Errors errors) {
    	
		if (grievanceVB == null) {
            return;
        }
       
    	validateRequiredRules(grievanceVB,errors);
		
		// validateOtherRules(profileVB,errors);
		
		//validateNestedObjectsRules(profileVB, errors);
        
    }
protected void validateRequiredRules(GrievanceVB grievanceVB, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "grievanceType","grievanceType.required");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "SSN","SSN.required");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactEmail","contactEmail.required");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginName","loginName.required");

	}


}

