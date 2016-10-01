package com.tronicsville.DAO.DaoImpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tronicsville.DAO.RegisterDao;
import com.tronicsville.model.RegisterModel;
@Repository
public class RegisterDaoImpl implements RegisterDao {
	@Autowired
	private SessionFactory sessionFactory;

	public RegisterDaoImpl(SessionFactory sessionFactory)
	{
		
		this.sessionFactory = sessionFactory;
	}
@Transactional
	public java.util.List<RegisterModel> List() {
		
		return null;
	}
@Transactional
	public RegisterModel get(String id) {
	String hql ="from RegisterModel where id=" + "'"+ id + "'";
		return getRegisterModel(hql);
	}
@Transactional
	public boolean update(RegisterModel register) {
	try
	{
	sessionFactory.getCurrentSession().update(register);
	}catch (Exception e)
	{
		e.printStackTrace();
		return false;
	}
	return true;	
	}
@Transactional
	public boolean delete(String id) {
	RegisterModel registerModel = new RegisterModel();
	registerModel.setId(id);
		try
		{
			sessionFactory.getCurrentSession().delete(registerModel);	
		}catch (Exception e)
		{
		e.printStackTrace();
		return false;
	}
		return true;
	}
@Transactional
	public RegisterModel isValidUser(String id, String password) {
	String hql ="from RegisterModel where id=" + "'"+ id + "'" + "and" 
	+ "password = " + "'" + password + "'";
		return getRegisterModel(hql);
	}
	private RegisterModel getRegisterModel(String hql)
	{
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<RegisterModel> list = (List<RegisterModel>) query.list();
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}
	@Transactional 
	public boolean save(RegisterModel registerModel){
		try
		{
			sessionFactory.getCurrentSession().save(registerModel);
		}catch (Exception e)
		{
	   e.printStackTrace();
	   return false;
		}
		return true;
	}
	}

