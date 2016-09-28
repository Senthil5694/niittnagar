package com.tronicsville.DAO.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tronicsville.DAO.CategoryDao;
import com.tronicsville.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		
		this.sessionFactory = sessionFactory;
	}

	public boolean save(Category category) {
		try
		{
			sessionFactory.getCurrentSession().save(category);
		}catch (Exception e)
		{
	   e.printStackTrace();
	   return false;
		}
		return true;
	}

	public boolean update(Category category) {
		try
		{
			sessionFactory.getCurrentSession().update(category);	
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

	public Category get(String id) {

		return null;
	}

	public List<Category> list() {

		return null;
	}
	
	

}
