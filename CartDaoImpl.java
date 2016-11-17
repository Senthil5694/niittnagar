package com.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.CartDao;
import com.Model.Cart;

@Transactional
@Repository("cartDao")
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public CartDaoImpl(SessionFactory sessionFactory)
	{
		
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveOrupdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	
	}
// this method will return list of cart details
	public List<Cart> list() {
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;	
	}
	
	
	public boolean delete(int cartid) {
		Cart cart = new Cart();
		cart.setCartid(cartid);
		try
		{
			sessionFactory.getCurrentSession().delete(cart);	
		}catch (Exception e)
		{
		e.printStackTrace();
		return false;
	}
		return true;
	}

	public Cart getCartById(int cartid) {
		Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartid);
	}

}
