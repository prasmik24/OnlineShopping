package com.lti.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.CategoryDaoImpl;

import com.lti.model.Category;

public class CategoryTest {

	CategoryDaoImpl dao = new CategoryDaoImpl();
	// ApplicationContext context=new
	// ClassPathXmlApplicationContext("spring-context.xml");
	// TestController controller=context.getBean(TestController.class);

	@Test
	public void addACategory() {
		Category cat = new Category();
		cat.setCategoryName("Mobile");

		// Admin admin=new Admin();
		// admin.setAdminName("King");
		// admin.setAdminEmail("king@gmail.com");

		dao.addACategory(cat);
	}

	@Test
	public void findACategory() {
		Category cat = dao.findACategory(202);
		System.out.println(cat.getCategoryName());
	}

	@Test
	public void viewAllCategories() {
		List<Category> categories = dao.viewAllCategories();

		for (Category c : categories) {
			System.out.println(c.getCategoryName());
		}

	}

}
