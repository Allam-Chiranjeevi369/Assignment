package com.assessment.userForm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.userForm.dao.UserDao;
import com.assessment.userForm.model.User;
import com.assessment.userForm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Transactional
	@Override
	public void persist(User user) {
		
		userDao.persist(user);
		
	}

	@Transactional
	@Override
	public List<Object[]> getByEmail(String userEmail) {
		
		var user = userDao.getByEmail(userEmail);
		return user;
		
	}

	@Transactional
	@Override
	public List<User> getAllUsers() {

		var users = userDao.getAllUsers();
		return users;
		
	}
	
}
