package com.lti.dao;

import com.lti.model.Cart;

public interface CartDao {

	public int addItemsToCart(Cart cart);
	public int emptyCart(Cart cart);
}
