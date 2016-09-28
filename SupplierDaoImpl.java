package com.tronicsville.DAO.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tronicsville.DAO.SupplierDao;
import com.tronicsville.model.Supplier;
@Repository
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		
		this.sessionFactory = sessionFactory;
	}

	public boolean save(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().save(supplier);
		}catch (Exception e)
		{
	   e.printStackTrace();
	   return false;
		}
		return true;
	}

	public boolean update(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
		}catch (Exception e)
		{
	   e.printStackTrace();
	   return false;
		}
		return true;	
	
	}

	public boolean delete(String id) {
		try
		{
			sessionFactory.getCurrentSession().delete(get(id));
		}catch (Exception e)
		{
	   e.printStackTrace();
	   return false;
		}
		return true;
	}

	public Supplier get(String id) {
		
    return null;

	}

	public List<Supplier> list() {
		
		return null;	
	}

}
