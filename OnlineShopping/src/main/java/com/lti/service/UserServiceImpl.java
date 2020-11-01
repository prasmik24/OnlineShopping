package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.UserDao;
import com.lti.model.Order;
import com.lti.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	public int updateUser(User user) {
		
		return userDao.updateUser(user);
	}

	public User findUser(int userId) {

		return userDao.findUser(userId);
	}

	public int addUserWithCart(User user) {
		/*if(userDao.addUserWithCart(user)>0) {
			//send registration email to user
		}*/
		
		return userDao.addUserWithCart(user);
	}

	public boolean loginUser(String userEmail, String password) {
		/*if(userDao.loginUser(userEmail, password)) {
			//open logged in homepage
		}*/
		return userDao.loginUser(userEmail, password);
	}

	public long placeOrder(Order order) {
		
		return userDao.placeOrder(order);
	}

}
