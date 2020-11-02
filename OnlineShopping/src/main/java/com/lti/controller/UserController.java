package com.lti.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.model.Order;
import com.lti.model.User;
import com.lti.service.UserService;

@Controller
public class UserController {

	/* Make a file "myFile.txt" and set its path in userService.buildEmailContent.
	 * This file will be used for fetching email body content.
	 * Give sender email address and sender email password when adding user with
	 * controller.addUserWithCart(_,_,_) method. Give valid mail address for each
	 * user added.*/
	
	@Autowired
	UserService userService;

	public int updateUser(User user) {

		return userService.updateUser(user);
	}

	public User findUser(int userId) {

		return userService.findUser(userId);
	}

	public int addUserWithCart(User user, String fromEmail, String fromPassword) throws IOException {

		return userService.addUserWithCart(user, fromEmail, fromPassword);
	}

	public boolean loginUser(String userEmail, String password) {

		return userService.loginUser(userEmail, password);
	}

	public long placeOrder(Order order) {

		return userService.placeOrder(order);
	}

}
