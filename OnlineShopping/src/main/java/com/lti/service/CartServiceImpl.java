package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.CartDao;
import com.lti.model.Cart;


@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao;
	
	public int addItemsToCart(Cart cart) {
		
		return cartDao.addItemsToCart(cart);
	}

	public int emptyCart(Cart cart) {
		return cartDao.emptyCart(cart);
	}

}
