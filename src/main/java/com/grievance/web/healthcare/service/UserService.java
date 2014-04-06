package com.grievance.web.healthcare.service;

import java.util.List;

import com.grievance.web.healthcare.newmodel.User;

public interface UserService {

	 public User checkCredentials(String loginName, String password);
	 
	 public boolean createUser(User user) ;
		
	 public List<User> findAllUsers();
	 
	 public boolean updateUser(User user);
	 
	 public boolean deleteUser(User user);
	 
	 public boolean activateUser(User user) ;

	boolean updatePassword(User user);
	 
	 
}
