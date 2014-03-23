package com.grievance.web.healthcare.manager;

import com.grievance.web.healthcare.viewbean.ProfileVB;

public interface UserManager {

	ProfileVB getUserDetails(String userName, String passWord);
	
	boolean createProfile(ProfileVB profileVB);
	
}
