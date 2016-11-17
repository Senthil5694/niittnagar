package com.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.RegisterDao;
import com.Model.Cart;
import com.Model.RegisterModel;
@Transactional
@Repository("registerDao")
public class RegisterDaoImpl implements RegisterDao{
	@Autowired
	private SessionFactory sessionFactory;

	public RegisterDaoImpl(SessionFactory sessionFactory)
	{
		
		this.sessionFactory = sessionFactory;
	}
	//this method is used to get the details of the user using username
	public RegisterModel get(String username) {
		String hql = "from RegisterModel where username =" + "'" + username + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<RegisterModel> list = (List<RegisterModel>) query.list();
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}
	//this method is used to update the registerdetails
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
//this method is used to delete single user from the database
	public boolean delete(String username) {
	RegisterModel registerModel = new RegisterModel();
	registerModel.setUsername(username);
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
//this method is used to used to validate the entered username and password
	public boolean isValidUser(String username, String password) {
	String hql ="from RegisterModel where username= '" + username + "' and " + " password ='" + password + "'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<RegisterModel> list = (List<RegisterModel>) query.list();
	if(list != null && !list.isEmpty())
	{
	
		return true;
	}
	
	return false;
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
	//this method is used to save the registerdetails
	public boolean save(RegisterModel registerModel){
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Cart newCart= new Cart();
			newCart.setRegisterModel(registerModel);
			registerModel.setCart(newCart);
			
			
			registerModel.setEnabled(true);
			session.save(registerModel);
			session.save(newCart);
		}catch (Exception e)
		{
	   e.printStackTrace();
	   return false;
		}
		return true;
	}
//this method is used to get all users from the database
	public List<RegisterModel> List() {
			@SuppressWarnings("unchecked")
			List<RegisterModel> list = (List<RegisterModel>) 
			          sessionFactory.getCurrentSession()
					.createCriteria(RegisterModel.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

			return list;
	}
//this method is used to get the userlist by using username
	public RegisterModel getcustomerbyusername(String username) {
		String hql = "from RegisterModel where username =" + "'" + username + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<RegisterModel> list = (List<RegisterModel>) query.list();
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}

}
