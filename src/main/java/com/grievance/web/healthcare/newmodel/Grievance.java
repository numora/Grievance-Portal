package com.grievance.web.healthcare.newmodel;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "grievance")
public class Grievance {
	
	
	private Integer grievance_id;
	private String grievance_type;
	private String ssn;
	private Integer contact_cell;
	private String contact_email;
	private String license_type;
	private Integer license_number;
	private Date lic_exp_date;
	private Integer npi;
	private Integer tax_id;
	private String exclusion_code;
	private String exclusion_desc;
	private String exclusion_date;
	private Member fedMember;
	private Member normalMember;
	
	@Id
	@Column(name = "grievance_id", unique = true, nullable = false)
	public Integer getGrievance_id() {
		return grievance_id;
	}
	public void setGrievance_id(Integer grievance_id) {
		this.grievance_id = grievance_id;
	}
	
	@Column(name = "grievance_type",  nullable = false)
	public String getGrievance_type() {
		return grievance_type;
	}
	public void setGrievance_type(String grievance_type) {
		this.grievance_type = grievance_type;
	}
	
	@Column(name = "ssn", unique = true, nullable = false)
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	@Column(name = "contact_cell")
	public Integer getContact_cell() {
		return contact_cell;
	}
	public void setContact_cell(Integer contact_cell) {
		this.contact_cell = contact_cell;
	}
	
	@Column(name = "contact_email")
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	
	@Column(name = "license_type")
	public String getLicense_type() {
		return license_type;
	}
	public void setLicense_type(String license_type) {
		this.license_type = license_type;
	}
	
	@Column(name = "license_number")
	public Integer getLicense_number() {
		return license_number;
	}
	public void setLicense_number(Integer license_number) {
		this.license_number = license_number;
	}
	
	@Column(name = "lic_exp_date")
	public Date getLic_exp_date() {
		return lic_exp_date;
	}
	public void setLic_exp_date(Date lic_exp_date) {
		this.lic_exp_date = lic_exp_date;
	}
	
	@Column(name = "npi")
	public Integer getNpi() {
		return npi;
	}
	public void setNpi(Integer npi) {
		this.npi = npi;
	}
	
	@Column(name = "tax_id")
	public Integer getTax_id() {
		return tax_id;
	}
	public void setTax_id(Integer tax_id) {
		this.tax_id = tax_id;
	}
	
	@Column(name = "exclusion_code")
	public String getExclusion_code() {
		return exclusion_code;
	}
	public void setExclusion_code(String exclusion_code) {
		this.exclusion_code = exclusion_code;
	}
	
	@Column(name = "exclusion_desc")
	public String getExclusion_desc() {
		return exclusion_desc;
	}
	public void setExclusion_desc(String exclusion_desc) {
		this.exclusion_desc = exclusion_desc;
	}
	
	@Column(name = "exclusion_date")
	public String getExclusion_date() {
		return exclusion_date;
	}
	public void setExclusion_date(String exclusion_date) {
		this.exclusion_date = exclusion_date;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Member getFedMember() {
		return fedMember;
	}
	public void setFedMember(Member fedMember) {
		this.fedMember = fedMember;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Member getNormalMember() {
		return normalMember;
	}
	public void setNormalMember(Member normalMember) {
		this.normalMember = normalMember;
	}
	
	
	
}


