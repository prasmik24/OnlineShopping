package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.model.Product;

public class ProductDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	public ProductDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	public void addAProductWithCateogary(Product product)
	{
		tx.begin();
		em.merge(product);
		tx.commit();
	}
	public Product findAProduct(int productId)
	{
		return em.find(Product.class, productId);
	}
	
}
