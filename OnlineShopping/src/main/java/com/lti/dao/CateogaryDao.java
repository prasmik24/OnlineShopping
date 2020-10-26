package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.model.Cateogary;

public class CateogaryDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	public CateogaryDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	public void addACateogary(Cateogary cateogary)
	{
		tx.begin();
		em.merge(cateogary);
		tx.commit();
	}
	public Cateogary findACateogary(int cateogaryID){
		return em.find(Cateogary.class, cateogaryID);
	}
}
