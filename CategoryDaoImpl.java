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
@Transactional
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
@Transactional
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
@Transactional
	public void delete(String id){
	Category category = new Category();
	category.setId(id);
	sessionFactory.getCurrentSession().delete(category);
}
@Transactional
	public Category get(String id) {

		return null;
	}
@Transactional
	public List<Category> list() {

		return null;
	}
	
	

}
