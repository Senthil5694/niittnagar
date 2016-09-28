package com.tronicsville.DAO.DaoImpl;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tronicsville.DAO.RegisterDao;
import com.tronicsville.model.RegisterModel;
@Repository
public class RegisterDaoImpl implements RegisterDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void RegisterDaoImpl(SessionFactory sessionFactory)
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
	public void saveorUpdate(RegisterModel registration) {
	try
	{
		sessionFactory.getCurrentSession().saveorUpdate(registration);
	}catch (Exception e)
	{
		e.printStackTrace();
	}
		
	}
@Transactional
	public void delete(String id) {
		try
		{
			sessionFactory.getCurrentSession().delete(get(id));	
		}catch (Exception e)
		{
		e.printStackTrace();
	}
		
	}
@Transactional
	public RegisterModel isValidUser(String id, String password) {
	String hql ="from RegisterModel where id=" + "'"+ id + "'" + "and" 
	+ "password = " + "'" + password + "'";
		return getRegisterModel(hql);
	}
	private RegisterModel getRegisterModel(String hql)
	{
		Query query = sessionFactory.getCurrentSessison().CreateQuery(hql);
		@SuppressWarnings("unchecked")
		List<RegisterModel> list = (List<RegisterModel>) query.list();
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}

}
