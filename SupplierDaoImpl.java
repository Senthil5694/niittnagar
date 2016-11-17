package com.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.SupplierDao;
import com.Model.Supplier;

@Transactional
@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		
		this.sessionFactory = sessionFactory;
	}
//this method is used to save supplierdetails
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
//this method is used to update supplierdetails
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
//this method is used to delete a supplier from database
	public boolean delete(String sid) {
	Supplier supplier = new Supplier();
	supplier.setSid(sid);
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
	
	//this method is used to get a supplier detail using supplierid
	public Supplier get(String sid) {
	String hql = "from Supplier where sid =" + "'" + sid + "'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Supplier> list = (List<Supplier>) query.list();
	if(list != null && !list.isEmpty())
	{
		return list.get(0);
	}
	return null;
}
	//this method is used to get all supplier details from the database
@Transactional
	public List<Supplier> list() {
	@SuppressWarnings("unchecked")
	List<Supplier> list = (List<Supplier>) 
	          sessionFactory.getCurrentSession()
			.createCriteria(Supplier.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

	return list;
			
	}
//this method is used to get a supplier detail by using supplier name
@Transactional
public Supplier getByName(String name) {

	String hql = "from Supplier where name=" + "'"+ name +"'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<Supplier> list = (List<Supplier>) query.list();
	
	if (list != null && !list.isEmpty()) {
		return list.get(0);
	}
	
	return null;
	
}

public void saveOrUpdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	

}

}
