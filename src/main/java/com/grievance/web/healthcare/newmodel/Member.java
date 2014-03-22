package com.grievance.web.healthcare.newmodel;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

public class Member {

	private Integer member_id;
	private String first_name;
	private String last_name;
	private Integer middle_initial;
	private String suffix;
	private String phone;
	private Address address;
	private Providers provider;
	
	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	@Column(name = "middle_initial")
	public Integer getMiddle_initial() {
		return middle_initial;
	}
	public void setMiddle_initial(Integer middle_initial) {
		this.middle_initial = middle_initial;
	}
	
	@Column(name = "suffix")
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Providers getProvider() {
		return provider;
	}
	public void setProvider(Providers provider) {
		this.provider = provider;
	}
	
	
}
