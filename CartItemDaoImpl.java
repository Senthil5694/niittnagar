package com.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.CartItemDao;
import com.Model.CartItem;

@Transactional
@Repository("cartitemdao")
public class CartItemDaoImpl implements CartItemDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public CartItemDaoImpl(SessionFactory sessionFactory)
	{
	
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveOrUpdate(CartItem cartitem) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartitem);
	 
		
	}

	public boolean delete(int cartitemid) {
		CartItem cartitem = new CartItem();
		cartitem.setCartitemid(cartitemid);
		try
		{
			sessionFactory.getCurrentSession().delete(cartitem);	
		}catch (Exception e)
		{
		e.printStackTrace();
		return false;
	}
		return true;
	}

	public CartItem getcartitem(int cartitemid) {
		String hql = "from CartItem where cartitemid =" + "'" + cartitemid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<CartItem> list = (List<CartItem>) query.list();
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}

	public List<CartItem> list() {
		@SuppressWarnings("unchecked")
		List<CartItem> list = (List<CartItem>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(CartItem.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;	
	}

	public List<CartItem> getcartitembyusername(String username) {
		String hql = "from CartItem where username =" + "'" + username + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<CartItem> list = (List<CartItem>) query.list();
		if(list != null && !list.isEmpty())
		{
		return list;
		}
		return null;
	}

	public void deletecartitem(CartItem cartitem) {
	        Session session = sessionFactory.getCurrentSession();
	        session.delete(cartitem);
	        session.flush();
	}

	/*public void removeCartItems(Cart cart) {
		 List<CartItem> cartItems = cart.getCartItems();

	        for (CartItem item : cartItems) {
	            getcartitem(item);
	        }
	        }*/
		
	}


	

