package com.Dao;

import com.Model.Order;

public interface OrderDao {
	public void saveorupdate(Order order);
	
	public double getcartgrandtotal(int cartid);

}
