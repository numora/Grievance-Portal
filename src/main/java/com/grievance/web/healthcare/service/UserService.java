package com.grievance.web.healthcare.service;

import java.util.List;

import com.grievance.web.healthcare.model.User;

public interface UserService {

	 public User checkCredentials(String loginName, String password);
	 
	 public boolean createUser(User user) ;
		
	 public List<User> findAllUsers();
	 
	 public boolean updateUser(User user);
	 
	 public boolean deleteUser(User user);
	 
}
