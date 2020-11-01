package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.model.Retailer;
import com.lti.service.AdminRetailerService;

@Controller
public class AdminRetailerController {

	@Autowired
	AdminRetailerService adminRetailerService;
	
	public int addOrUpdateRetailer(Retailer retailer) {
		
		return adminRetailerService.addOrUpdateRetailer(retailer);
	}

	public Retailer findARetailer(int retailerId) {
		
		return adminRetailerService.findARetailer(retailerId);
	}

	public List<Retailer> viewAllRetailers() {
		
		return adminRetailerService.viewAllRetailers();
	}
}
