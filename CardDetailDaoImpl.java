package com.DaoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.CardDetailDao;
import com.Model.CardDetail;

@Transactional
@Repository("carddetaildao")
public class CardDetailDaoImpl implements CardDetailDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public CardDetailDaoImpl(SessionFactory sessionFactory)
	{
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveOrUpdate(CardDetail carddetail) {
		sessionFactory.getCurrentSession().saveOrUpdate(carddetail);
		
	}

}
