package com.lti.service;

import java.util.List;

import com.lti.model.Retailer;

public interface AdminRetailerService {

	public int addOrUpdateRetailer(Retailer retailer);
	public Retailer findARetailer(int retailerId);
	public List<Retailer> viewAllRetailers();
}
