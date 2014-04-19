package com.grievance.web.healthcare.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grievance.web.healthcare.manager.BaseManager;
import com.grievance.web.healthcare.manager.GrievanceManager;
import com.grievance.web.healthcare.newmodel.Grievance;
import com.grievance.web.healthcare.service.GrievanceService;
import com.grievance.web.healthcare.service.GrievanceWorkflowService;
import com.grievance.web.healthcare.viewbean.GrievanceVB;

@Component
public class GrievanceManagerImpl extends BaseManager implements
		GrievanceManager {
	static final Logger logger = LoggerFactory
			.getLogger(GrievanceManagerImpl.class);

	@Autowired
	private GrievanceService grievanceService;
	
	@Autowired
	private GrievanceWorkflowService grievanceWorkflowService;

	public GrievanceVB createGrievance(GrievanceVB grievanceVB) {

		logger.debug("START: Create Greivance()::Create the Grievance");

		grievanceWorkflowService.startGrievanceWorkflow();
		
		boolean isGrievanceCreated = false;

		Grievance grievance = new Grievance();
		grievance = (Grievance) dozerTransformer.retrieveMap(grievanceVB,
				grievance, null);

		System.out.println("After Dozzer Map:" + grievance);

		isGrievanceCreated = grievanceService.createGrievance(grievance);
		if (grievance != null && isGrievanceCreated) {
			grievanceVB.setGrievanceId(grievance.getGrievance_id());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("END: createGreivance()");
		}
		return grievanceVB;

	}

	@Override
	public GrievanceVB trackGrievance(GrievanceVB grievanceVB) {
		Grievance grievance = new Grievance();
		grievance = (Grievance) dozerTransformer.retrieveMap(grievanceVB,
				grievance, null);

		System.out.println("After Dozzer Map:" + grievance);

		grievance = grievanceService.trackGrievance(grievance);

		if (logger.isDebugEnabled()) {
			logger.debug("END: trackGrievance()");
		}
		if (grievance != null) {
			grievanceVB.setContactPhone(grievance.getContact_cell());
			grievanceVB.setExclusionCode(grievance.getExclusion_code());
			grievanceVB.setExclusionDesc(grievance.getExclusion_desc());
			grievanceVB.setExclusionDate(grievance.getExclusion_date());
			grievanceVB.setGrievanceType(grievance.getGrievance_type());
			grievanceVB.setLicenseExpDate(grievance.getLic_exp_date());
			grievanceVB.setLicenseNumber(grievance.getLicense_number());
			grievanceVB.setLicenseType(grievance.getLicense_type());
			grievanceVB.setTaxonomy(grievance.getTaxonomy());
			grievanceVB.setNpi(grievance.getNpi());
			grievanceVB.setTaxId(grievance.getTax_id());
		}
		return grievanceVB;

	}

	public GrievanceVB getGrievanceDetails(GrievanceVB grievanceVB) {
		Grievance grievance = new Grievance();
		grievance = (Grievance) dozerTransformer.retrieveMap(grievanceVB,
				grievance, null);

		grievance = grievanceService.getGrievanceDetails(grievance);

		if (logger.isDebugEnabled()) {
			logger.debug("END: trackGrievance()");
		}
		if (grievance != null) {
			grievanceVB.setContactEmail(grievance.getContact_email());
			grievanceVB.setSSN(grievance.getSsn());
			grievanceVB.setContactPhone(grievance.getContact_cell());
			grievanceVB.setExclusionCode(grievance.getExclusion_code());
			grievanceVB.setExclusionDesc(grievance.getExclusion_desc());
			grievanceVB.setExclusionDate(grievance.getExclusion_date());
			grievanceVB.setGrievanceType(grievance.getGrievance_type());
			grievanceVB.setLicenseExpDate(grievance.getLic_exp_date());
			grievanceVB.setLicenseNumber(grievance.getLicense_number());
			grievanceVB.setLicenseType(grievance.getLicense_type());
			grievanceVB.setTaxonomy(grievance.getTaxonomy());
			grievanceVB.setNpi(grievance.getNpi());
			grievanceVB.setTaxId(grievance.getTax_id());
		}
		return grievanceVB;
	}

	@Override
	public GrievanceVB getGrievanceDetailsByMemberId(GrievanceVB grievanceVB) {
		return getGrievanceDetails(grievanceVB);
	}

	@Override
	public GrievanceVB getGrievanceDetailsByGrievanceId(GrievanceVB grievanceVB) {
		return getGrievanceDetails(grievanceVB);
	}

	@Override
	public GrievanceVB getGrievanceDetailsBySSN(GrievanceVB grievanceVB) {
		return getGrievanceDetails(grievanceVB);
	}

	@Override
	public List<GrievanceVB> getAllGrievances() {
		List<Grievance> grievances = grievanceService.getAllGrievances();
		List<GrievanceVB> grievancesVB = new ArrayList<GrievanceVB>();
		for (Grievance grievance : grievances) {
			if (grievance != null) {
				GrievanceVB grievanceVB = new GrievanceVB();
				grievanceVB.setContactEmail(grievance.getContact_email());
				grievanceVB.setSSN(grievance.getSsn());
				grievanceVB.setContactPhone(grievance.getContact_cell());
				grievanceVB.setExclusionCode(grievance.getExclusion_code());
				grievanceVB.setExclusionDesc(grievance.getExclusion_desc());
				grievanceVB.setExclusionDate(grievance.getExclusion_date());
				grievanceVB.setGrievanceType(grievance.getGrievance_type());
				grievanceVB.setLicenseExpDate(grievance.getLic_exp_date());
				grievanceVB.setLicenseNumber(grievance.getLicense_number());
				grievanceVB.setLicenseType(grievance.getLicense_type());
				grievanceVB.setTaxonomy(grievance.getTaxonomy());
				grievanceVB.setNpi(grievance.getNpi());
				grievanceVB.setTaxId(grievance.getTax_id());
				grievanceVB.setGrievanceId(grievance.getGrievance_id());
				grievancesVB.add(grievanceVB);
			}
		}
		return grievancesVB;
	}
}
