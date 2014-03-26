package com.grievance.web.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.grievance.web.healthcare.constants.CommonConstants.Action;
import com.grievance.web.healthcare.util.HelperUtil;

public abstract class BaseController {

	@Autowired
	protected HelperUtil helperUtil;

	public abstract String getViewName();

	protected String getFormView(Action action) {
		return action.formView();
	}

	protected String getRedirectView(Action action) {
		return action.redirectView();
	}

}
