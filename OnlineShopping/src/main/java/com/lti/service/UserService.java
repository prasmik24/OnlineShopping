package com.lti.service;

import com.lti.model.Order;
import com.lti.model.User;

public interface UserService {

	public int updateUser(User user);
	public User findUser(int userId);
	public int addUserWithCart(User user);
	public boolean loginUser(String userEmail, String password);
	public long placeOrder(Order order);
}
