package com.grievance.web.healthcare.newmodel;

import java.util.Date;

public class Member {

	private Integer member_id;
	private String first_name;
	private String last_name;
	private Integer middle_initial;
	private Date suffix;
	private Date phone;
	private Address address;
	private Providers provider;
	
	
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Integer getMiddle_initial() {
		return middle_initial;
	}
	public void setMiddle_initial(Integer middle_initial) {
		this.middle_initial = middle_initial;
	}
	public Date getSuffix() {
		return suffix;
	}
	public void setSuffix(Date suffix) {
		this.suffix = suffix;
	}
	public Date getPhone() {
		return phone;
	}
	public void setPhone(Date phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Providers getProvider() {
		return provider;
	}
	public void setProvider(Providers provider) {
		this.provider = provider;
	}
	
	
}
