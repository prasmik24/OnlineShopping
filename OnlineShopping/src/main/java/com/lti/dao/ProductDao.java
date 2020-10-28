package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Category;
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
	
	
	public List<Product> viewAllProducts(){
		String jpql= "select p from Product p";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		return query.getResultList();		
		
	}
	
	public List<Product> viewProductByCategory(String category){
		String jpql = "select p from Product p where p.category=:catg";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		query.setParameter("catg", category);
		
		return query.getResultList();
	}
	
}
