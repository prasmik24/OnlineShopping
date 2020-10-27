package com.lti.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.CategoryDao;
import com.lti.dao.ProductDao;
import com.lti.dao.UserDao;
import com.lti.model.Cart;
import com.lti.model.Category;
import com.lti.model.Product;
import com.lti.model.User;

public class UserTest {

	UserDao dao = new UserDao();
	ProductDao dao1=new ProductDao();
	CategoryDao dao2=new CategoryDao();

	@Test
	public void addACategory()
	{
		Category category=new Category();
		category.setCategoryName("Mobile Phones");
		dao2.addACategory(category);
	}
	@Test
	public void addAProduct(){
		Category category=dao2.findACategory(1001);
		List<Product> products=new ArrayList<Product>();
		Product p1=new Product();
		p1.setProductName("Samsung");
		p1.setProductPrice(10000.00);
		p1.setProductQuantity(10);
		p1.setProductDescription("4GB RAM,64GB ROM");
		p1.setProductManufacturerName("Samsung India");
		//Retailer Details by Rohan
		p1.setCategory(category);
		products.add(p1);
		
		Product p2=new Product();
		p2.setProductName("Apple");
		p2.setProductPrice(50000.00);
		p2.setProductQuantity(50);
		p2.setProductDescription("4GB RAM,128GB ROM");
		p2.setProductManufacturerName("Apple India");
		p2.setCategory(category);
		products.add(p2);
		
		category.setProduct(products);
		dao1.addAProductWithCateogary(category);
	}
}
