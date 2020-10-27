package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.dao.UserDao;
import com.lti.model.Cart;

import com.lti.model.User;

public class UserTest {

	UserDao dao = new UserDao();

	@Test
	public void addUserWithCart() {
		Cart cart = new Cart();
		User registerUser = new User();
		registerUser.setUserName("John");
		registerUser.setUserEmail("john@lti.com");
		registerUser.setUserMobile("9977886655");
		registerUser.setUserPassword("john123");
		registerUser.setCart(cart);

		cart.setUser(registerUser);
		// cart.setRegisterUser(registerUser);
		registerUser.setCart(cart);

		dao.addUserWithCart(registerUser);
	}
}
