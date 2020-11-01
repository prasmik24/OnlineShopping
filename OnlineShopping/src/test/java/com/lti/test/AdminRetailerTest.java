package com.lti.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.AdminRetailerDaoImpl;
import com.lti.model.AddressRetailer;
import com.lti.model.Admin;
import com.lti.model.Retailer;

public class AdminRetailerTest {
	
	AdminRetailerDaoImpl dao = new AdminRetailerDaoImpl();
//	ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
//	TestController controller=context.getBean(TestController.class);

	@Test
	public void addOrUpdateRetailer() {
		Retailer retail = new Retailer();
		retail.setRetailerName("DEF Retailers");
		retail.setRetailerEmail("defretailer@gmail.com");
		
		AddressRetailer address = new AddressRetailer();
		address.setCity("Delhi");
		address.setState("New Delhi");
		address.setStreet("MG Road");
		address.setRetailer(retail);
		retail.setAddress(address);
		
//		Admin admin=new Admin();
//		admin.setAdminName("King");
//		admin.setAdminEmail("king@gmail.com");
		
		dao.addOrUpdateRetailer(retail);
		
	}
	
	@Test
	public void findAretailer() {
		Retailer retailer = dao.findARetailer(102);
		System.out.println(retailer.getRetailerName()+ " " + retailer.getAddress().getCity());
	}
	
	
	@Test
	public void viewAllRetailers() {
		List<Retailer> retailers = dao.viewAllRetailers();
		
		for(Retailer r: retailers) {
			System.out.println(r.getRetailerName()+" "+r.getRetailerEmail());
		}
		
	}

}
