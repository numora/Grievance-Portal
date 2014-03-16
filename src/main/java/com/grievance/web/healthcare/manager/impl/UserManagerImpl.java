package com.grievance.web.healthcare.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grievance.web.healthcare.manager.UserManager;
import com.grievance.web.healthcare.model.User;
import com.grievance.web.healthcare.service.UserService;
import com.grievance.web.healthcare.viewbean.UserVB;

@Component
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserVB getUserDetails(String userName, String passWord) {
		
		System.out.println("In Manager");
		UserVB userVB = null;
		User user = userService.checkCredentials(userName, passWord);
		if(user!=null){
			userVB = new UserVB();
			userVB.setEmail(user.getEmailAddress());
			userVB.setFirstName(user.getLoginname());
			System.out.println("Email Addres" + userVB.getEmail());
		}
		return userVB;
	}

}
