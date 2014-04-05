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

import com.grievance.web.healthcare.constants.CommonConstants.Action;
import com.grievance.web.healthcare.exception.GenericException;
import com.grievance.web.healthcare.manager.UserManager;
import com.grievance.web.healthcare.viewbean.ProfileVB;

@Controller
@RequestMapping("/activateProfile")
public class ActivateProfileController extends BaseController {
	static final Logger logger = LoggerFactory
			.getLogger(ActivateProfileController.class);

	public static final String VIEW_NAME = "activateProfile";

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
	public String activateProfile(
			@ModelAttribute(PROFILE_MODEL_ATTRIBUTE_NAME) ProfileVB profileVB,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) throws GenericException {

		logger.debug("START: activate Profile ()" + profileVB.toString());
		System.out.println("In ActivateProfile Controller");

		// profileValidator.validatePortalVB(profileVB,result);

		if (result.hasErrors()) {
			return getSuccessView(Action.activateProfile);
		}
		try {
			profileVB.setActivateId(Integer.parseInt(request
					.getParameter("activateId")));
			profileVB.setEmail(request.getParameter("email"));
			userManager.activateProfile(profileVB);
			request.getSession(false).setAttribute("signedIn", 1);
		} catch (Exception ex) {
			throw new GenericException(
					"Exception occurred while Activating Profile In ProfileController",
					ex);
		}
		return getSuccessView(Action.activateProfile);
	}

}
