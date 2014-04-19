package com.grievance.web.healthcare.manager;

import java.util.List;

import com.grievance.web.healthcare.viewbean.GrievanceVB;

public interface GrievanceManager {

	GrievanceVB createGrievance(GrievanceVB grievanceVB);
	public GrievanceVB trackGrievance(GrievanceVB grievanceVB);
	public GrievanceVB getGrievanceDetailsByMemberId(GrievanceVB grievanceVB);
	public GrievanceVB getGrievanceDetailsByGrievanceId(GrievanceVB grievanceVB);
	public GrievanceVB getGrievanceDetailsBySSN(GrievanceVB grievanceVB);
	public List<GrievanceVB> getAllGrievances();
}
