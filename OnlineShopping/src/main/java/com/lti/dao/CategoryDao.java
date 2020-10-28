package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	public List<Category> viewAllCategories(){
		String jpql= "select c from Category c";
		TypedQuery<Category> query = em.createQuery(jpql, Category.class);
		return query.getResultList();
	}
}
