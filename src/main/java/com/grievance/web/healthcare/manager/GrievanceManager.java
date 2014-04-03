package com.grievance.web.healthcare.manager;

import com.grievance.web.healthcare.viewbean.GrievanceVB;

public interface GrievanceManager {

	GrievanceVB createGrievance(GrievanceVB grievanceVB);
	public GrievanceVB trackGrievance(GrievanceVB grievanceVB);
}
