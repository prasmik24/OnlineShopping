package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.model.Retailer;

@Repository
public class AdminRetailerDaoImpl implements AdminRetailerDao {

	@PersistenceContext
	EntityManager em;
	
	/*Retailer should have address and admin*/
	@Transactional
	public int addOrUpdateRetailer(Retailer retailer)
	{
		Retailer persistedRetailer=em.merge(retailer);
		return persistedRetailer.getRetailerId();
	}
	public Retailer findARetailer(int retailerId)
	{
		return em.find(Retailer.class, retailerId);
	}
	public List<Retailer> viewAllRetailers()
	{
		TypedQuery<Retailer> query=em.createQuery("select r from Retailer r", Retailer.class);
		return query.getResultList();
	}
}
