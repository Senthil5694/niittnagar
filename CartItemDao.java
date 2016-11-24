package com.Dao;

import java.util.List;

//import com.Model.Cart;
import com.Model.CartItem;

public interface CartItemDao {

	public void saveOrUpdate(CartItem cartitem);
	
	public boolean delete(int cartitemid);
	
	public CartItem getcartitem(int cartitemid);
	
	public List<CartItem> list();
	
	public void deletecartitem(CartItem cartitem);
	
	public List<CartItem> getcartitembyusername(String username);
	
	public CartItem getcartbycartid(int cartid);
	
	//public void removeCartItems(Cart cart);
	

	
	
	
	
}
