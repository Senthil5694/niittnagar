package com.tronicsville.DAO.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tronicsville.DAO.ProductDao;
import com.tronicsville.model.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		
		this.sessionFactory = sessionFactory;
	}

	public boolean save(Product product) {
		try
		{
			sessionFactory.getCurrentSession().save(product);
		}catch (Exception e)
		{
	  e.printStackTrace();
	  return false;
		}
		return true;
	}

	public boolean update(Product product) {
		
		try
		{
			sessionFactory.getCurrentSession().update(product);
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

	public Product get(String id) {
	
		return null;
	}

	public List<Product> list() {
	
		return null;
	}

}
