package com.grievance.web.healthcare.manager.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grievance.web.healthcare.controller.ProfileController;
import com.grievance.web.healthcare.manager.BaseManager;
import com.grievance.web.healthcare.manager.UserManager;
import com.grievance.web.healthcare.model.User;
import com.grievance.web.healthcare.service.UserService;
import com.grievance.web.healthcare.viewbean.ProfileVB;

@Component
public class UserManagerImpl extends BaseManager implements UserManager {
	
	static final Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);

	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public ProfileVB getUserDetails(String userName, String passWord) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("START: getUserDetails()::Retrieve the User Details Based on Login Name and Password");
		}
		
		ProfileVB userVB = null;
		User user = userService.checkCredentials(userName, passWord);
		if(user!=null){
			userVB = new ProfileVB();
			userVB.setEmail(user.getEmailAddress());
			userVB.setFirstName(user.getLoginname());
			System.out.println("Email Addres" + userVB.getEmail());
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("END: getUserDetails()");
		}
		
		return userVB;
	}
	
	public boolean createProfile(ProfileVB profileVB) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("START: createProfile()::Create the User");
		}
		
		boolean isProfileCreated = false;
		
		User user = new User();
		user = (User) dozerTransformer.retrieveMap(profileVB,user,null);
		
		if (logger.isDebugEnabled()) {
			logger.debug("END: createUser()");
		}
        return isProfileCreated;
		
	}

}
