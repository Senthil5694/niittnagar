package com.Dao;

import com.Model.BillingAddress;

public interface BillingAddressDao {
	public void saveOrupdate(BillingAddress billingaddress);
	public boolean delete(String billingaddressid);
	public BillingAddress getbillingaddress(String billingaddressid);
}
