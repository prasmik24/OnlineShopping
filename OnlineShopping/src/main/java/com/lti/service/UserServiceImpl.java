package com.lti.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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

	public int addUserWithCart(User user, String fromEmail, String fromPassword) throws IOException {
		int userId = userDao.addUserWithCart(user);
		if (userId > 0) {
		}
		return userId;
	}

	public boolean loginUser(String userEmail, String password) {
		/*
		 * if(userDao.loginUser(userEmail, password)) { //open logged in homepage }
		 */
		return userDao.loginUser(userEmail, password);
	}

	public long placeOrder(Order order) {

		return userDao.placeOrder(order);
	}
}
