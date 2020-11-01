package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.model.Order;
import com.lti.model.User;
import com.lti.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
public int updateUser(User user) {
		
		return userService.updateUser(user);
	}

	public User findUser(int userId) {

		return userService.findUser(userId);
	}

	public int addUserWithCart(User user) {
		
		return userService.addUserWithCart(user);
	}

	public boolean loginUser(String userEmail, String password) {

		return userService.loginUser(userEmail, password);
	}

	public long placeOrder(Order order) {
		
		return userService.placeOrder(order);
	}

}
