package com.grievance.web.healthcare.manager;

import org.springframework.beans.factory.annotation.Autowired;

import com.grievance.web.healthcare.transform.DozerTransformer;

public class BaseManager {
	
	protected DozerTransformer dozerTransformer;
	
	@Autowired
	public void setDozerTransformer(DozerTransformer dozerTransformer) {
		this.dozerTransformer = dozerTransformer;
	}

}
