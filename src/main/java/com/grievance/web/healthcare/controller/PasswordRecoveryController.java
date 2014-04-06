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
@RequestMapping("/passwordRecovery")
public class PasswordRecoveryController extends BaseController {

		static final Logger logger = LoggerFactory
				.getLogger(PasswordRecoveryController.class);
		public static final String VIEW_NAME = "passwordRecovery";

		public static final String PROFILE_MODEL_ATTRIBUTE_NAME = "profileVB";

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
			return getFormView(Action.PasswordRecovery);
		}

		@RequestMapping(method = RequestMethod.POST)
		public String updatePassword(
				@ModelAttribute(PROFILE_MODEL_ATTRIBUTE_NAME) ProfileVB profileVB,
				BindingResult result, HttpServletRequest request,
				HttpServletResponse response) throws GenericException {

			logger.debug("START: Create Profile ()" + profileVB.toString());
			System.out.println("In Profile Controller");
			try {
				profileVB.setEmail(request.getParameter("email"));
				profileVB.setActivateId(1);
				userManager.updatePassword(profileVB);
				request.getSession().setAttribute("signedIn", 1);
			} catch (Exception ex) {
				throw new GenericException(
						"Exception occurred while Activating Profile In ProfileController",
						ex);
			}
			return getSuccessView(Action.PasswordRecovery);
		}

	}


