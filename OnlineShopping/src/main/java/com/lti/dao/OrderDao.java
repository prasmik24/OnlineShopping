package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Order;
import com.lti.model.Payment;

public class OrderDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	public OrderDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	public void placeOrder(Order order) {
		tx.begin();
		em.merge(order);
		tx.commit();
	}
	
	public Order findOrderById(int orderId) {
		String jpql = "select o from Order o where o.orderid=:ordId";
		TypedQuery<Order> query = em.createQuery(jpql, Order.class);
		query.setParameter("ordId", orderId);
		return query.getSingleResult();
	}
	
	public List<Order> findOrderByUserId(int userId){
		String jpql = "select o from Order o where o.user_id=:userid";
		TypedQuery<Order> query = em.createQuery(jpql, Order.class);
		query.setParameter("userid", userId);
		return query.getResultList();
	}
	
	public void makePayment(Payment payment) {
		tx.begin();
		em.merge(payment);
		tx.commit();
	}
}
