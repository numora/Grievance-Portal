package com.grievance.web.healthcare.controller;

import com.grievance.web.healthcare.manager.UserManager;
import com.grievance.web.healthcare.viewbean.ProfileVB;
import com.grievance.web.healthcare.viewbean.SignInVB;
import com.grievance.web.healthcare.exception.GenericException;
import com.grievance.web.healthcare.bean.validators.ProfileVBValidator;
import com.grievance.web.healthcare.bean.validators.SignInVBValidator;
import com.grievance.web.healthcare.constants.CommonConstants.Action;

import static com.grievance.web.healthcare.constants.CommonConstants.SIGN_IN_MODEL_ATTRIBUTE_NAME;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/signin")
public class SignInController extends BaseController {

	static final Logger logger = LoggerFactory.getLogger(SignInController.class);
	
	public static final String VIEW_NAME = "signin";
	
	public static final String MODEL_ATTRIBUTE_NAME = "signInVB";

	public String getViewName() {
		return VIEW_NAME;
	}

	@Autowired
	private SignInVBValidator signInValidator;
	
	@Autowired
	private UserManager userManager;

    @ModelAttribute(MODEL_ATTRIBUTE_NAME)
    public SignInVB buildModel() {
        return new SignInVB();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setupSignInForm(
            @ModelAttribute(MODEL_ATTRIBUTE_NAME) SignInVB signInVB,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	  System.out.println("In Sign in Controller");
          return getFormView(Action.SignIn);
    }

    @RequestMapping(params = "processSignIn", method = RequestMethod.POST)
	public String processSignIn(
			@ModelAttribute(SIGN_IN_MODEL_ATTRIBUTE_NAME) SignInVB signInVB,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) throws GenericException {

    	logger.debug("In Process Signin ");
    	ProfileVB profileVB = null;
    	
		System.out.print("Process Signin"+signInVB.getLoginName());
		signInValidator.validatePortalVB(signInVB,result);
		
		if (result.hasErrors()) {
			System.out.print("Errors");
			return getFormView(Action.SignIn);
		}

		try {
			profileVB = userManager.getUserDetails(signInVB.getLoginName(),signInVB.getPassword());
            if(profileVB!= null){
            	System.out.println("User Successfully Logined"+ profileVB.getLastName());
            	return getFormView(Action.Success);
            }
		} catch (Exception ex) {
			throw new GenericException(
					"Exception occurred while processing authenticateUser in SignInController",
					ex);
		}
		return getFormView(Action.SignIn);
	}
}