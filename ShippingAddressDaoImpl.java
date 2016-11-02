package com.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.ShippingAddressDao;
import com.Model.ShippingAddress;

@Transactional
@Repository("shippingddressDao")
public class ShippingAddressDaoImpl implements ShippingAddressDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public ShippingAddressDaoImpl(SessionFactory sessionFactory)
	{
		
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ShippingAddress get(String shippingaddressid) {
		String hql = "from ShippingAddress where shippingaddressid=" + "'"+ shippingaddressid +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<ShippingAddress> list = (List<ShippingAddress>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}

	public boolean delete(String shippingaddressid) {
		ShippingAddress shippingaddress = new ShippingAddress();
		shippingaddress.setShippingaddressid(shippingaddressid);
		try
		{
			sessionFactory.getCurrentSession().delete(shippingaddressid);	
		}catch (Exception e)
		{
		e.printStackTrace();
		return false;
	}
		return true;
	}


	public void saveOrupdate(ShippingAddress shippingaddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(shippingaddress);
		
	}

}
