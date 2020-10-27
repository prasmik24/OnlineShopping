package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.model.User;

public class UserDao {
	
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	public UserDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	public void updateUser(User user) {
		tx.begin();
		em.merge(user);
		tx.commit();
	}
	
	public User findUser(int userId) {
		return em.find(User.class, userId);
	}
	
	public void addUserWithCart(User user) {
		tx.begin();
		em.merge(user);
		tx.commit();
	}
	
}
