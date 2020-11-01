package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminRetailerDao;
import com.lti.model.Retailer;


@Service
public class AdminRetailerServiceImpl implements AdminRetailerService {
	
	@Autowired
	AdminRetailerDao adminRetailerDao;

	public int addOrUpdateRetailer(Retailer retailer) {
		
		return adminRetailerDao.addOrUpdateRetailer(retailer);
	}

	public Retailer findARetailer(int retailerId) {
		
		return adminRetailerDao.findARetailer(retailerId);
	}

	public List<Retailer> viewAllRetailers() {
		
		return adminRetailerDao.viewAllRetailers();
	}

}
