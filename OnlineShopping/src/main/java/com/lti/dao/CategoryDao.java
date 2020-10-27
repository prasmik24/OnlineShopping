package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.model.Category;

public class CategoryDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	public CategoryDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	public void addACategory(Category category)
	{
		tx.begin();
		em.merge(category);
		tx.commit();
	}
	public Category findACategory(int categoryID){
		return em.find(Category.class, categoryID);
	}
}
