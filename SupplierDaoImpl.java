package com.tronicsville.DAO.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tronicsville.DAO.SupplierDao;
import com.tronicsville.model.Category;
import com.tronicsville.model.Supplier;
@Repository("supplierDao")
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
	String hql = "from Supplier where id =" + "'" + id + "'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Supplier> list = (List<Supplier>) query.list();
	if(list != null && !list.isEmpty())
	{
		return list.get(0);
	}
	return null;
}
@Transactional
	public List<Supplier> list() {
		
		return null;	
	}
@Transactional
public Supplier getByName(String name) {

	String hql = "from Supplier where name=" + "'"+ name+"'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<Supplier> list = (List<Supplier>) query.list();
	
	if (list != null && !list.isEmpty()) {
		return list.get(0);
	}
	
	return null;
	
}

}
