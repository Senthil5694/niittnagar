package com.tronicsville.DAO.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
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
@Transactional
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
@Transactional
	public boolean delete(String id) {
	Supplier supplier = new Supplier();
	supplier.setId(id);
	try
	{
		sessionFactory.getCurrentSession().delete(supplier);
	}catch (Exception e)
	{
   e.printStackTrace();
   return false;
	}
	return true;	
	
	}
@Transactional
	public Supplier get(String id) {
		
    return null;

	}
@Transactional
	public List<Supplier> list() {
		
		return null;	
	}

}
