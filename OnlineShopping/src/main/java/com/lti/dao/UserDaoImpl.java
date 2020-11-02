package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.model.Order;
import com.lti.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public int updateUser(User user) {
		User persistedUser=em.merge(user);
		return persistedUser.getUserId();
	}
	
	public User findUser(int userId) {
		return em.find(User.class, userId);
	}
	
	@Transactional
	public int addUserWithCart(User user) {
		User persistedUser=em.merge(user);
		return persistedUser.getUserId();
	}
	
	public boolean loginUser(String userEmail, String password)
	{
		String jpql="select count(u) from User u where u.userEmail=:uemail and u.userPassword=:upwd";
		Query query=em.createQuery(jpql, Long.class);
		query.setParameter("uemail", userEmail);
		query.setParameter("upwd", password);
		if(Integer.parseInt(query.getSingleResult().toString())>0) {
			return true;
		}
		return false;
	}
	
	@Transactional
	public long placeOrder(Order order)
	{
		Order persistedOrder=em.merge(order);
		return persistedOrder.getOrderId();
	}
}
