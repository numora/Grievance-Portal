package com.grievance.web.healthcare.viewbean;

public class SignInVB extends BaseVB {

    private  String loginName;
    
	private  String email;
    
    private  String password;

    public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}