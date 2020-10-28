package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.model.Order;
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
		System.out.println();
	}
	
	public User findUser(int userId) {
		return em.find(User.class, userId);
	}
	
	public void addUserWithCart(User user) {
		tx.begin();
		em.merge(user);
		tx.commit();
	}
	
	public boolean loginUser(int userId, String password)
	{
		String jpql="select u from User u where u.userId=:uid and u.userPassword=:pwd";
		Query query=em.createQuery(jpql, User.class);
		query.setParameter("uid", userId);
		query.setParameter("pwd", password);
		if(query.getFirstResult()>0)
			return true;
		return false;
	}
	
	public void placeOrder(Order order)
	{
		tx.begin();
		em.merge(order);
		tx.commit();
	}
}
