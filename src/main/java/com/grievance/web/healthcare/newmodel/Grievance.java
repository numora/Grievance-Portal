package com.grievance.web.healthcare.newmodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "grievance")
@NamedQueries({@NamedQuery(name = "grievance.trackGrievnace", query = "from Grievance where grievance_id = :grievanceId and contact_email= :email and ssn =:ssn"), 
@NamedQuery(name = "grievance.getGrievanceBySSN", query = "from Grievance where ssn =:ssn"),@NamedQuery(name = "grievance.getGrievanceByID", query = "from Grievance where grievance_id = :grievanceId"),@NamedQuery(name = "grievance.getAllGrievances", query = "from Grievance")})
public class Grievance {

	private int grievance_id;
	private int grievance_type;
	private String ssn;
	private String contact_cell;
	private String contact_email;
	private String license_type;
	private long license_number;
	private Date lic_exp_date;
	private long npi;
	private long tax_id;
	private String exclusion_code;
	private String exclusion_desc;
	private Date exclusion_date;
	private String taxonomy;
	private int fed_member_id;
	private int member_id;
	private Member member;
	private Member fedmember;

	@Id
	@Column(name = "grievance_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getGrievance_id() {
		return grievance_id;
	}

	public void setGrievance_id(int grievance_id) {
		this.grievance_id = grievance_id;
	}

	@Column(name = "grievance_type", nullable = false)
	public int getGrievance_type() {
		return grievance_type;
	}

	public void setGrievance_type(int grievance_type) {
		this.grievance_type = grievance_type;
	}

	@Column(name = "ssn", nullable = false)
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Column(name = "contact_cell", nullable = false)
	public String getContact_cell() {
		return contact_cell;
	}

	public void setContact_cell(String contact_cell) {
		this.contact_cell = contact_cell;
	}

	@Column(name = "contact_email", nullable = false)
	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

	@Column(name = "license_type", nullable = false)
	public String getLicense_type() {
		return license_type;
	}

	public void setLicense_type(String license_type) {
		this.license_type = license_type;
	}

	@Column(name = "license_number", nullable = false)
	public long getLicense_number() {
		return license_number;
	}

	public void setLicense_number(long license_number) {
		this.license_number = license_number;
	}

	@Column(name = "lic_exp_date", nullable = false)
	public Date getLic_exp_date() {
		return lic_exp_date;
	}

	public void setLic_exp_date(Date lic_exp_date) {
		this.lic_exp_date = lic_exp_date;
	}

	@Column(name = "npi", nullable = false)
	public long getNpi() {
		return npi;
	}

	public void setNpi(long npi) {
		this.npi = npi;
	}

	@Column(name = "tax_id", nullable = false)
	public long getTax_id() {
		return tax_id;
	}

	public void setTax_id(long tax_id) {
		this.tax_id = tax_id;
	}

	@Column(name = "exclusion_code", nullable = false)
	public String getExclusion_code() {
		return exclusion_code;
	}

	public void setExclusion_code(String exclusion_code) {
		this.exclusion_code = exclusion_code;
	}

	@Column(name = "exclusion_desc", nullable = false)
	public String getExclusion_desc() {
		return exclusion_desc;
	}

	public void setExclusion_desc(String exclusion_desc) {
		this.exclusion_desc = exclusion_desc;
	}

	@Column(name = "exclusion_date", nullable = false)
	public Date getExclusion_date() {
		return exclusion_date;
	}

	public void setExclusion_date(Date exclusion_date) {
		this.exclusion_date = exclusion_date;
	}

	@Column(name = "taxonomy", nullable = false)
	public String getTaxonomy() {
		return taxonomy;
	}

	public void setTaxonomy(String taxonomy) {
		this.taxonomy = taxonomy;
	}

	@Column(name = "fed_member_id")
	public int getFed_member_id() {
		return fed_member_id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Member getFedmember() {
		return fedmember;
	}

	public void setFedmember(Member fedmember) {
		this.fedmember = fedmember;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setFed_member_id(int fed_member_id) {
		this.fed_member_id = fed_member_id;
	}

	@Column(name = "member_id")
	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

}