package com.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.BillingAddressDao;
import com.Model.BillingAddress;

@Transactional
@Repository("billingaddressDao")
public class BillingAddressDaoImpl implements BillingAddressDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public BillingAddressDaoImpl(SessionFactory sessionFactory)
	{
		
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BillingAddress getbillingaddress(String billingaddressid) {
		String hql = "from BillingAddress where billingaddressid=" + "'"+ billingaddressid +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<BillingAddress> list = (List<BillingAddress>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}

	public boolean delete(String billingaddressid) {
		BillingAddress billingaddress = new BillingAddress();
		billingaddress.setBillingaddressid(billingaddressid);
		try
		{
			sessionFactory.getCurrentSession().delete(billingaddress);	
		}catch (Exception e)
		{
		e.printStackTrace();
		return false;
	}
		return true;
	}

	public void saveOrupdate(BillingAddress billingaddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(billingaddress);
		
	}

}
