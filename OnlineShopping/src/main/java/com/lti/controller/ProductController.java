package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.model.Product;
import com.lti.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	public int addAProductWithCategory(Product product) {

		return productService.addAProductWithCategory(product);
	}

	public Product findAProduct(int productId) {
		
		return productService.findAProduct(productId);
	}

	public List<Product> viewAllProducts() {
		return productService.viewAllProducts();
	}

	public List<Product> viewProductByCategory(String category) {
		return productService.viewProductByCategory(category);
	}
	
}
