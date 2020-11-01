package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.model.Cart;

@Repository
public class CartDaoImpl implements CartDao {
	
	@PersistenceContext
	EntityManager em;

	@Transactional
	public int addItemsToCart(Cart cart) {
		Cart persistedCart=em.merge(cart);
		return persistedCart.getCartId();
	}
	
	@Transactional
	public int emptyCart(Cart cart) {
		String jpql ="delete i from Item i where i.cart.cart_id=:cartid";
		Query query = em.createQuery(jpql);
		query.setParameter("cartid", cart.getCartId());
		int num = query.executeUpdate();
		
		if(num>0) {
			System.out.println("Cart is emptied");
		}
		return num;
	}
}
