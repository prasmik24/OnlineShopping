package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.model.Retailer;

public class AdminRetailerDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	public AdminRetailerDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	/*Retailer should have address and admin*/
	public void addOrUpdateRetailer(Retailer retailer)
	{
		tx.begin();
		em.merge(retailer);
		tx.commit();
	}
	public Retailer findARetailer(int retailerId)
	{
		return em.find(Retailer.class, retailerId);
	}
	public List<Retailer> viewAllRetailers()
	{
		Query query=em.createQuery("select r from Retailer r", Retailer.class);
		return query.getResultList();
	}
}
