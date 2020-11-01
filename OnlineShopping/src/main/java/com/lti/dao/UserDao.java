package com.lti.dao;

import com.lti.model.Order;
import com.lti.model.User;

public interface UserDao {

	public int updateUser(User user);
	public User findUser(int userId);
	public int addUserWithCart(User user);
	public boolean loginUser(int userId, String password);
	public long placeOrder(Order order);
}
