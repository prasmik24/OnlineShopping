package com.lti.dao;

import java.util.List;

import com.lti.model.Retailer;

public interface AdminRetailerDao {

	public int addOrUpdateRetailer(Retailer retailer);
	public Retailer findARetailer(int retailerId);
	public List<Retailer> viewAllRetailers();
}
