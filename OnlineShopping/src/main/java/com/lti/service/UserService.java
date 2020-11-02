package com.lti.service;

import java.io.IOException;

import com.lti.model.Order;
import com.lti.model.User;

public interface UserService {

	public int updateUser(User user);
	public User findUser(int userId);
	public int addUserWithCart(User user, String fromEmail, String fromPassword) throws IOException;
	public boolean loginUser(String userEmail, String password);
	public long placeOrder(Order order);
	public void sendEmailToUser(User user, String fromEmail, String fromPassword) throws IOException;
	public String buildEmailContent(User user) throws IOException;
}
