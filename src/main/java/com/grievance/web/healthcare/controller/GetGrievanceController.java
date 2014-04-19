/**************************************************************************
 *
 * Name: GetGrievanceController.java
 *
 * Created By: 
 *
 * Project Name: Grievance Portal
 *
 * Description: To Handle the Creation of Grievance 
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

import com.grievance.web.healthcare.bean.validators.GrievanceVBValidator;
import com.grievance.web.healthcare.constants.CommonConstants.Action;
import com.grievance.web.healthcare.exception.GenericException;
import com.grievance.web.healthcare.manager.GrievanceManager;
import com.grievance.web.healthcare.viewbean.GrievanceVB;

@Controller
@RequestMapping("/getGrievance")
public class GetGrievanceController extends BaseController {
	static final Logger logger = LoggerFactory
			.getLogger(ProfileController.class);
	public static final String VIEW_NAME = "getGrievance";
	public static final String GRIEVANCE_MODEL_ATTRIBUTE_NAME = "grievanceVB";

	@Autowired
	private GrievanceVBValidator grievanceVBValidator;

	@Autowired
	private GrievanceManager grievanceManager;

	public String getViewName() {
		return VIEW_NAME;
	}

	@ModelAttribute(GRIEVANCE_MODEL_ATTRIBUTE_NAME)
	public GrievanceVB buildModel(HttpServletRequest request)
			throws GenericException {
		return new GrievanceVB();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupGrievanceForm(
			@ModelAttribute(GRIEVANCE_MODEL_ATTRIBUTE_NAME) GrievanceVB grievanceVB,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return getFormView(Action.getGrievance);
	}

	@RequestMapping(params = "getGrievance", method = RequestMethod.POST)
	public String getGrievance(
			@ModelAttribute(GRIEVANCE_MODEL_ATTRIBUTE_NAME) GrievanceVB grievanceVB,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) throws GenericException {

		logger.debug("START: Get Grievance" + grievanceVB.toString());
		System.out.println("In Get Grievance Controller");

		// grievanceVBValidator.validatePortalVB(grievanceVB,result);

		if (result.hasErrors()) {
			return getFormView(Action.getGrievance);
		}

		try {
			if (null != grievanceVB.getSSN()) {
				grievanceVB = grievanceManager
						.getGrievanceDetailsBySSN(grievanceVB);
			} else if (0 != grievanceVB.getGrievanceId()) {
				grievanceVB = grievanceManager
						.getGrievanceDetailsByGrievanceId(grievanceVB);
			} else if (0 != grievanceVB.getMemberVB().getMemberId()) {
				grievanceVB = grievanceManager
						.getGrievanceDetailsByMemberId(grievanceVB);
			}

			if (null == grievanceVB.getContactEmail()) {
				grievanceVB.setNodetails(true);
			}
		} catch (Exception ex) {
			throw new GenericException(
					"Exception occurred while getting Grievance In GetGrievanceController",
					ex);
		}
		return getSuccessView(Action.getGrievance);
	}

}
