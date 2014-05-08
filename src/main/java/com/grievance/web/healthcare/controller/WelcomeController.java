package com.grievance.web.healthcare.controller;



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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class WelcomeController extends BaseController {

	static final Logger logger = LoggerFactory
			.getLogger(WelcomeController.class);
          

	public static final String VIEW_NAME = "welcome";

	public static final String MODEL_ATTRIBUTE_NAME = "welcome";

	public String getViewName() {
		return VIEW_NAME;
	}

	

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
            System.out.println("in welcome");
 
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return getFormView(Action.Welcome);
 
	}
}
 