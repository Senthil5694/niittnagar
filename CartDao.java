package com.Dao;

import java.util.List;

import com.Model.Cart;

public interface CartDao {
	public Cart getCartById (int cartid);
public void saveOrupdate(Cart cart);
public boolean delete(int cartid);
public List<Cart> list();

}
