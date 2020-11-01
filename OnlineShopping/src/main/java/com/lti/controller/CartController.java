package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.model.Cart;
import com.lti.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService cartService;

	public int addItemsToCart(Cart cart) {
		
		return cartService.addItemsToCart(cart);
	}

	public int emptyCart(Cart cart) {
		return cartService.emptyCart(cart);
	}
}
