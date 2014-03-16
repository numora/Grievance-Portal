package com.grievance.web.healthcare.controller;

import static com.grievance.web.healthcare.constants.CommonConstants.SIGN_IN_MODEL_ATTRIBUTE_NAME;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grievance.web.healthcare.bean.validators.SignInVBValidator;
import com.grievance.web.healthcare.constants.CommonConstants.Action;
import com.grievance.web.healthcare.exception.GenericException;
import com.grievance.web.healthcare.viewbean.RegistryVB;
import com.grievance.web.healthcare.viewbean.SignInVB;


@Controller
@RequestMapping("/registration")
public class RegistrationController extends BaseController {
	
public static final String VIEW_NAME = "createregistry";
	
	public static final String MODEL_ATTRIBUTE_NAME = "registrationVB";

	public String getViewName() {
		return VIEW_NAME;
	}

	@ModelAttribute(MODEL_ATTRIBUTE_NAME)
    public RegistryVB buildModel() {
        return new RegistryVB();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setupSignInForm(
            @ModelAttribute(MODEL_ATTRIBUTE_NAME) RegistryVB registryVB,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	  System.out.println("In Registration Controller");
          return getFormView(Action.Registration);
    }

    @RequestMapping(params = "createRegistry", method = RequestMethod.POST)
	public String authenticateUser(
			@ModelAttribute(SIGN_IN_MODEL_ATTRIBUTE_NAME) RegistryVB registryVB,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) throws GenericException {

		System.out.print("Create Registry"+registryVB.getEmail());
		if (result.hasErrors()) {
			return "";
		}

		try {

		} catch (Exception ex) {
			throw new GenericException(
					"Exception occurred while processing authenticateUser in SignInController",
					ex);
		}
		return "";
	}
	
}
