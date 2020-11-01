package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.model.Category;
import com.lti.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	public int addACategory(Category category) {
		
		return categoryService.addACategory(category);
	}

	public Category findACategory(int categoryID) {
		
		return categoryService.findACategory(categoryID);
	}

	public List<Category> viewAllCategories() {
		
		return categoryService.viewAllCategories();
	}
}
