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
	
	@Transactional
	public long placeOrder(Order order)
	{
		Order persistedOrder=em.merge(order);
		return persistedOrder.getOrderId();
	}
}
