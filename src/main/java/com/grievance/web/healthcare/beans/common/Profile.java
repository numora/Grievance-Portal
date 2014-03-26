package com.grievance.web.healthcare.beans.common;

public class Profile extends BaseBean {

    private static final long serialVersionUID = -8589161036053954366L;
    
    private String email;
    
   	private String confirmEmail;
    
    private String password;
    
    private String confirmPassword;
    
    private String loginName;
    
    private String gender;
    
    private String birthDate;
    
    private int date;
    
    private int year;
    
    private int month;
    
    private Phone contactNumber;
    
    private Contact profileAddress;
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Phone getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Phone contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Contact getProfileAddress() {
		return profileAddress;
	}

	public void setProfileAddress(Contact profileAddress) {
		this.profileAddress = profileAddress;
	}
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Profile [email=");
        builder.append(email);
        builder.append(", confirmEmail=");
        builder.append(confirmEmail);
        builder.append(", loginName=");
        builder.append(loginName);
        builder.append(", gender=");
        builder.append(gender);
        builder.append(", birthDate=");
        builder.append(birthDate);
        builder.append(", contactNumber=");
        builder.append(contactNumber);
        builder.append(", profileAddress=");
        builder.append(profileAddress);
        builder.append("]");
        return builder.toString();
    }

}
