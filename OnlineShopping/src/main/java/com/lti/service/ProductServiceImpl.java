package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ProductDao;
import com.lti.model.Product;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;

	public int addAProductWithCategory(Product product) {

		return productDao.addAProductWithCategory(product);
	}

	public Product findAProduct(int productId) {
		/*if(productDao.findAProduct(productId)==null) {
			//product not found
		}*/
		return productDao.findAProduct(productId);
	}

	public List<Product> viewAllProducts() {
		return productDao.viewAllProducts();
	}

	public List<Product> viewProductByCategory(String category) {
		return productDao.viewProductByCategory(category);
	}

}
