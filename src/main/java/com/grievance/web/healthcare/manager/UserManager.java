package com.grievance.web.healthcare.manager;

import com.grievance.web.healthcare.viewbean.UserVB;

public interface UserManager {

	UserVB getUserDetails(String userName, String passWord);
	
}
