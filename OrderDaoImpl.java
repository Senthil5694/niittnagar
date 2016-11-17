package com.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.CartDao;
import com.Dao.OrderDao;
import com.Model.Cart;
import com.Model.CartItem;
import com.Model.Order;

@Transactional
@Repository("orderdao")
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CartDao cartdao;
	
	@Autowired
	public OrderDaoImpl(SessionFactory sessionFactory)
	{
	
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveorupdate(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
      
		
	}

	public double getcartgrandtotal(int cartid) {
		 double grandTotal=0;
         Cart cart = cartdao.getCartById(cartid);
         List<CartItem> cartItems = cart.getCartItems();

         for (CartItem item : cartItems) {
             grandTotal+=item.getTotal();
         }

         return grandTotal;
	}
	

}
