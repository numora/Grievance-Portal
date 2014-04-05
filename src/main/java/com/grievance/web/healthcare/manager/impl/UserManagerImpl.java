package com.grievance.web.healthcare.manager.impl;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grievance.web.healthcare.manager.BaseManager;
import com.grievance.web.healthcare.manager.UserManager;
import com.grievance.web.healthcare.newmodel.User;
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
		if (user != null) {
			userVB = new ProfileVB();
			userVB.setEmail(user.getEmail_id());
			userVB.setFirstName(user.getLogin_name());
			System.out.println("Email Addres" + userVB.getEmail());
		}

		if (logger.isDebugEnabled()) {
			logger.debug("END: getUserDetails()");
		}

		return userVB;
	}

	public boolean createProfile(ProfileVB profileVB) {

		logger.debug("START: createProfile()::Create the User");

		boolean isProfileCreated = false;

		User user = new User();
		user = (User) dozerTransformer.retrieveMap(profileVB, user, null);
		user.setActivate_id(randInt(100000, 999999));

		System.out.println("After Dozzer Map:" + user.getEmail_id());

		System.out.println("After Dozzer Map:" + user);

		isProfileCreated = userService.createUser(user);
		if (logger.isDebugEnabled()) {
			logger.debug("END: createUser()");
		}
		return isProfileCreated;

	}

	public boolean activateProfile(ProfileVB profileVB) {

		logger.debug("START: createProfile()::Create the User");

		boolean isProfileActivated = false;

		User user = new User();
		user.setEmail_id(profileVB.getEmail());
		user.setActivate_id(profileVB.getActivateId());
		// user = (User) dozerTransformer.retrieveMap(profileVB,user,null);
		isProfileActivated = userService.activateUser(user);
		if (logger.isDebugEnabled()) {
			logger.debug("END: createUser()");
		}
		return isProfileActivated;

	}

	public static int randInt(int min, int max) {

		// Usually this can be a field rather than a method variable
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

}
