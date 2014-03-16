package com.grievance.web.healthcare.controller;

import com.grievance.web.healthcare.constants.CommonConstants.Action;

public abstract class BaseController {

	   public abstract String getViewName();
	   
	   protected String getFormView(Action action) {
	        return action.formView();
	    }

	    protected String getRedirectView(Action action) {
	        return action.redirectView();
	    }
	  
}
