package com.Dao;

import java.util.List;

import com.Model.Cart;

public interface CartDao {
public void saveOrupdate(Cart cart);
public boolean delete(String cartid);
public List<Cart> list();

}
