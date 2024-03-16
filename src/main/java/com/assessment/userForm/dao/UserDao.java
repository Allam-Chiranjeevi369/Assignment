package com.assessment.userForm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.assessment.userForm.model.User;

@Repository
public interface UserDao {
	
//	For registering new user into DB.
	public void persist(User user);
	
//	Retrieve user by email.
	public List<Object[]> getByEmail(String userEmail);
	
//	Get all user details.
	public List<User> getAllUsers();
	
}
