package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.dao.UserDaoImpl;
import com.lti.model.AddressUser;
import com.lti.model.Cart;

import com.lti.model.User;

public class UserTest {

	UserDaoImpl dao = new UserDaoImpl();

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

		AddressUser address=new AddressUser();
		address.setCity("Kolkata");
		address.setState("West Bengal");
		address.setStreet("Saltlake");
		
		address.setUser(registerUser);
		registerUser.setAddress(address);
		
		dao.addUserWithCart(registerUser);
	}
}
