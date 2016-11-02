package com.Dao;

import com.Model.ShippingAddress;

public interface ShippingAddressDao {
	public void saveOrupdate(ShippingAddress shippingaddress);
	public boolean delete(String shippingaddressid);
	public ShippingAddress get(String shippingaddressid);
}
