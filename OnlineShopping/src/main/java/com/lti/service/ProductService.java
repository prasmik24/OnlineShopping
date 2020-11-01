package com.lti.service;

import java.util.List;

import com.lti.model.Product;

public interface ProductService {

	public int addAProductWithCategory(Product product);
	public Product findAProduct(int productId);
	public List<Product> viewAllProducts();
	public List<Product> viewProductByCategory(String category);
}
