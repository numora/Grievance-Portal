package com.grievance.web.healthcare.manager.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grievance.web.healthcare.manager.BaseManager;
import com.grievance.web.healthcare.manager.GrievanceManager;
import com.grievance.web.healthcare.newmodel.Grievance;
import com.grievance.web.healthcare.service.GrievanceService;
import com.grievance.web.healthcare.viewbean.GrievanceVB;

@Component
public class GrievanceManagerImpl extends BaseManager implements GrievanceManager {
	static final Logger logger = LoggerFactory
			.getLogger(GrievanceManagerImpl.class);

	@Autowired
	private GrievanceService grievanceService;
	
	public boolean createGrievance(GrievanceVB grievanceVB) {

		logger.debug("START: createProfile()::Create the User");

		boolean isGrievanceCreated = false;

		Grievance grievance = new Grievance();
		grievance = (Grievance) dozerTransformer.retrieveMap(grievanceVB, grievance, null);

		System.out.println("After Dozzer Map:" + grievance);

		isGrievanceCreated = grievanceService.createGrievance(grievance);
		if (logger.isDebugEnabled()) {
			logger.debug("END: createUser()");
		}
		return isGrievanceCreated;

	}
}
