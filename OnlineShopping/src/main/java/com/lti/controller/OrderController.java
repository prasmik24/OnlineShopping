package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.model.Order;
import com.lti.model.Payment;
import com.lti.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;

	public Order findOrderById(int orderId) {

		return orderService.findOrderById(orderId);
	}

	public List<Order> findOrderByUserId(int userId) {

		return orderService.findOrderByUserId(userId);
	}

	public int makePayment(Payment payment) {
		
		return orderService.makePayment(payment);
	}
}
