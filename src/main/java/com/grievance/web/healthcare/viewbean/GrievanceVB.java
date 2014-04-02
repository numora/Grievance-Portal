package com.grievance.web.healthcare.viewbean;

import java.util.Date;

public class GrievanceVB {

	private int grievanceType;
	private String SSN;
	private String contactEmail;
	private String contactPhone;
	private String licenseType;
	private long licenseNumber;
	private Date licenseExpDate;
	private long npi;
	private long taxId;
	private String exclusionCode;
	private String exclusionDesc;
	private Date exclusionDate;
	private String taxonomy;
	private MemberVB memberVB;
	private MemberVB fedMemberVB;
	

	public int getGrievanceType() {
		return grievanceType;
	}

	public void setGrievanceType(int grievanceType) {
		this.grievanceType = grievanceType;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public long getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(long licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Date getLicenseExpDate() {
		return licenseExpDate;
	}

	public void setLicenseExpDate(Date licenseExpDate) {
		this.licenseExpDate = licenseExpDate;
	}

	public long getNpi() {
		return npi;
	}

	public void setNpi(long npi) {
		this.npi = npi;
	}

	public long getTaxId() {
		return taxId;
	}

	public void setTaxId(long taxId) {
		this.taxId = taxId;
	}

	public String getExclusionCode() {
		return exclusionCode;
	}

	public void setExclusionCode(String exclusionCode) {
		this.exclusionCode = exclusionCode;
	}

	public String getExclusionDesc() {
		return exclusionDesc;
	}

	public void setExclusionDesc(String exclusionDesc) {
		this.exclusionDesc = exclusionDesc;
	}

	public Date getExclusionDate() {
		return exclusionDate;
	}

	public void setExclusionDate(Date exclusionDate) {
		this.exclusionDate = exclusionDate;
	}

	public String getTaxonomy() {
		return taxonomy;
	}

	public void setTaxonomy(String taxonomy) {
		this.taxonomy = taxonomy;
	}

	public MemberVB getMemberVB() {
		return memberVB;
	}

	public void setMemberVB(MemberVB memberVB) {
		this.memberVB = memberVB;
	}

	public MemberVB getFedMemberVB() {
		return fedMemberVB;
	}

	

	public void setFedMemberVB(MemberVB fedMemberVB) {
		this.fedMemberVB = fedMemberVB;
	}

}
