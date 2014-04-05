
/**************************************************************************
	 *
	 * Name: TrackGrievanceController.java
	 *
	 * Created By: 
	 *
	 * Project Name: Grievance Portal
	 *
	 * Description: To track any  Grievance 
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

import com.grievance.web.healthcare.constants.CommonConstants.Action;
import com.grievance.web.healthcare.exception.GenericException;
import com.grievance.web.healthcare.manager.GrievanceManager;
import com.grievance.web.healthcare.viewbean.GrievanceVB;
	
	@Controller
	@RequestMapping("/trackGrievance")
	public class TrackGrievanceController extends BaseController {

		static final Logger logger = LoggerFactory
				.getLogger(ProfileController.class);
		public static final String VIEW_NAME = "trackGrievance";
		public static final String GRIEVANCE_MODEL_ATTRIBUTE_NAME = "grievanceVB";

		/*
		 * @Autowired private ProfileVBValidator profileValidator;
		 */

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

			logger.debug("Debug Statement");
			logger.info("Info Statment");
			logger.error("Error Statement");
			return getFormView(Action.TrackGrievance);
		}

		@RequestMapping(params = "trackGrievance", method = RequestMethod.POST)
		public String trackGrievance(
				@ModelAttribute(GRIEVANCE_MODEL_ATTRIBUTE_NAME) GrievanceVB grievanceVB,
				BindingResult result, HttpServletRequest request,
				HttpServletResponse response) throws GenericException {

			logger.debug("START: Track Grievance" + grievanceVB.toString());
			System.out.println("In Track Grievance Controller");

			// profileValidator.validatePortalVB(profileVB,result);

			if (result.hasErrors()) {
				return getFormView(Action.TrackGrievance);
			}

			try {
				grievanceManager.trackGrievance(grievanceVB);
			} catch (Exception ex) {
				throw new GenericException(
						"Exception occurred while Creating Grievance In TrackGrievanceController",
						ex);
			}
			return getSuccessView(Action.TrackGrievance);
		}

	}


