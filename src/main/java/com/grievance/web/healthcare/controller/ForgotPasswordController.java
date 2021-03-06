package com.grievance.web.healthcare.controller;

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

import com.grievance.web.healthcare.bean.validators.ProfileVBValidator;
import com.grievance.web.healthcare.constants.CommonConstants.Action;
import com.grievance.web.healthcare.exception.GenericException;
import com.grievance.web.healthcare.manager.UserManager;
import com.grievance.web.healthcare.util.MailUtilImpl;
import com.grievance.web.healthcare.viewbean.ProfileVB;

@Controller
@RequestMapping("/forgotPassword")
public class ForgotPasswordController extends BaseController {

	static final Logger logger = LoggerFactory
			.getLogger(ForgotPasswordController.class);
	public static final String VIEW_NAME = "forgotPassword";

	public static final String PROFILE_MODEL_ATTRIBUTE_NAME = "profileVB";
	private MailUtilImpl mailUtilImpl = new MailUtilImpl();

	@Autowired
	private ProfileVBValidator profileValidator;

	@Autowired
	private UserManager userManager;

	public String getViewName() {
		return VIEW_NAME;
	}

	@ModelAttribute(PROFILE_MODEL_ATTRIBUTE_NAME)
	public ProfileVB buildModel(HttpServletRequest request)
			throws GenericException {
		return new ProfileVB();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForgotPasswordForm(
			@ModelAttribute(PROFILE_MODEL_ATTRIBUTE_NAME) ProfileVB profileVB,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return getFormView(Action.ForgotPassword);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String forgotPasswordMail(
			@ModelAttribute(PROFILE_MODEL_ATTRIBUTE_NAME) ProfileVB profileVB,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) throws GenericException {

		logger.debug("START: Create Profile ()" + profileVB.toString());
		System.out.println("In Profile Controller");
		try {
			mailUtilImpl.sendPasswordRecoveryMail("Forgot Password",
					profileVB.getEmail());
		} catch (Exception ex) {
			throw new GenericException(
					"Exception occurred while Creating Profile In ProfileController",
					ex);
		}
		return getSuccessView(Action.ForgotPassword);
	}

}
