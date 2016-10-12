package com.tronicsville.DAO.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tronicsville.DAO.CategoryDao;
import com.tronicsville.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;
	
@Autowired
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public boolean delete(String id){
	Category category = new Category();
	category.setId(id);
	try
	{
		sessionFactory.getCurrentSession().delete(category);	
	}catch (Exception e)
	{
	e.printStackTrace();
	return false;
}
	return true;
}
@Transactional
	public Category get(String id) {
	String hql = "from Category where id =" + "'" + id + "'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Category> list = (List<Category>) query.list();
	if(list != null && !list.isEmpty())
	{
		return list.get(0);
	}
	return null;
}

	
@Transactional
	public List<Category> list() {	
	@SuppressWarnings("unchecked")
	List<Category> list = (List<Category>) sessionFactory.getCurrentSession();
     return list;	
	}
@Transactional
public Category getByName(String name) {
	
	String hql = "from Category where name=" + "'"+ name +"'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<Category> list = (List<Category>) query.list();
	
	if (list != null && !list.isEmpty()) {
		return list.get(0);
	}
	
	return null;
}
	
	

}
