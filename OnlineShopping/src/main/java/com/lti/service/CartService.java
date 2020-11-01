package com.lti.service;

import com.lti.model.Cart;

public interface CartService {

	public int addItemsToCart(Cart cart);
	public int emptyCart(Cart cart);
}
