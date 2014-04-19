package com.grievance.web.healthcare.service;

import java.util.List;

import com.grievance.web.healthcare.newmodel.Grievance;
import com.grievance.web.healthcare.viewbean.GrievanceVB;

public interface GrievanceService {
	public boolean createGrievance(Grievance grievance) ;
	public Grievance trackGrievance(Grievance grievance);
	public Grievance getGrievanceDetails(Grievance grievance);
	public List<Grievance> getAllGrievances();
}
