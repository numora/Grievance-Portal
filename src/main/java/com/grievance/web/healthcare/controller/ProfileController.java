/**************************************************************************
 *
 * Name: ProfileController.java
 *
 * Created By: 
 *
 * Project Name: Grievance Portal
 *
 * Description: To Handle the Creation of Profile 
 *
 *************************************************************************/

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
import com.grievance.web.healthcare.helper.KillSwitchHelper;
import com.grievance.web.healthcare.manager.UserManager;
import com.grievance.web.healthcare.util.MailUtilImpl;
import com.grievance.web.healthcare.viewbean.ProfileVB;

@Controller
@RequestMapping("/createProfile")
public class ProfileController extends BaseController {

	static final Logger logger = LoggerFactory
			.getLogger(ProfileController.class);

	public static final String VIEW_NAME = "createProfile";

	public static final String PROFILE_MODEL_ATTRIBUTE_NAME = "profileVB";
	private MailUtilImpl mailUtilImpl = new MailUtilImpl();

	@Autowired
	private ProfileVBValidator profileValidator;

	@Autowired
	private UserManager userManager;

	private KillSwitchHelper killSwitchHelper;

	@Autowired
	public void setKillSwitchHelper(KillSwitchHelper killSwitchHelper) {
		this.killSwitchHelper = killSwitchHelper;
	}

	public String getViewName() {
		return VIEW_NAME;
	}

	@ModelAttribute(PROFILE_MODEL_ATTRIBUTE_NAME)
	public ProfileVB buildModel(HttpServletRequest request)
			throws GenericException {
		return populateProfileVB(request, new ProfileVB());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupProfileForm(
			@ModelAttribute(PROFILE_MODEL_ATTRIBUTE_NAME) ProfileVB profileVB,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return getFormView(Action.CreateProfile);
	}

	private ProfileVB populateProfileVB(HttpServletRequest request,
			ProfileVB profileVB) {
		if (null == profileVB) {
			profileVB = new ProfileVB();
		}
		profileVB.setStates(helperUtil.getStates());
		return profileVB;
	}

	@RequestMapping(params = "createProfile", method = RequestMethod.POST)
	public String createProfile(
			@ModelAttribute(PROFILE_MODEL_ATTRIBUTE_NAME) ProfileVB profileVB,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) throws GenericException {

		logger.debug("START: Create Profile ()" + profileVB.toString());
		System.out.println("In Profile Controller");
		profileValidator.validatePortalVB(profileVB, result);
		if (result.hasErrors()) {
			return getFormView(Action.CreateProfile);
		}
		try {
			if (!this.killSwitchHelper.getControlEmailValue()) {
				profileVB.setActivateId(1);
			}
			userManager.createProfile(profileVB);
			request.getSession(false).setAttribute("signedIn", 1);
			if (this.killSwitchHelper.getControlEmailValue()) {
				mailUtilImpl.sendProfileActivateMail("Profile Created",
						profileVB.getEmail(), profileVB.getActivateId());
			}
		} catch (Exception ex) {
			throw new GenericException(
					"Exception occurred while Creating Profile In ProfileController",
					ex);
		}
		return getSuccessView(Action.CreateProfile);
	}

}
