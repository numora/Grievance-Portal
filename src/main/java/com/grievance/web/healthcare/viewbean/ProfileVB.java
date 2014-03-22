package com.grievance.web.healthcare.viewbean;

import com.grievance.web.healthcare.beans.common.Address;
import com.grievance.web.healthcare.beans.common.Phone;

public class ProfileVB extends BaseVB {

	private String email;
	
	private String loginName;
	
	private String password;
	
	private String confirmPassword;
	
	private String firstName;
	
	private String lastName;

    private  Address addressVB;
    
    private Phone phone;

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddressVB() {
		return addressVB;
	}

	public void setAddressVB(Address addressVB) {
		this.addressVB = addressVB;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}	
    
}
