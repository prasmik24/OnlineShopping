package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.model.Cart;

public class CartDao {
	
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	public CartDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public void addItemsToCart(Cart cart) {
		tx.begin();
		em.merge(cart);
		tx.commit();
	}
	
	public void emptyCart(Cart cart) {
		String jpql ="delete i from items i where i.cart_id=:cartid";
		Query query = em.createQuery(jpql);
		
		tx.begin();
		int num = query.executeUpdate();
		tx.commit();
		
		if(num>0) {
			System.out.println("Cart is emptied");
		}
	}

}
