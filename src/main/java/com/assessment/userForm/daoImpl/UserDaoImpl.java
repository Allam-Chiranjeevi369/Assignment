package com.assessment.userForm.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assessment.userForm.dao.UserDao;
import com.assessment.userForm.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public void persist(User user) {
		
		var session = entityManager.unwrap(Session.class);
		try {
//			Persists only if Email is unique.
			session.persist(user);
			session.close();
		}catch (PersistenceException  e) {
	        System.out.println("username already exist");
	    }
		
	}

	@Override
	public List<Object[]> getByEmail(String userEmail) {

		var session = entityManager.unwrap(Session.class);
		var query = session.createSelectionQuery("FROM User u WHERE u.userMail =: userEmail",Object[].class);
		query.setParameter("userEmail", userEmail);
		var user = query.getResultList();
		session.close();
		return user;
		
	}

	@Override
	public List<User> getAllUsers() {
		
		var session = entityManager.unwrap(Session.class);
		var query = session.createSelectionQuery("FROM User",User.class);
		var users = query.getResultList();
		session.close();
		return users;
		
	}


}
