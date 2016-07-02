package com.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import dao.CollectionDao;
import entity.Collection;

public class CollectionDaoImpl extends HibernateTemplate implements CollectionDao {

	
	@Resource
	public SessionFactory sessionFactory;
	
	
	@Override
	public void insertCollection(Collection collection) {
		this.save(collection);

	}

	@Override
	public void updateCollection(Collection collection) {
		this.saveOrUpdate(collection);

	}

	

	@Override
	public List selectCollectionByUserId(int id) {
		String hql = "from Collection where userId =?";
		List list = this.find(hql, id);
		return list;
	}

	

	@Override
	public void deleteCollectionById(int userId, int messageId) {
		String hql = "from Collection where userId = ? and messageId = ?";
		Collection collection = (Collection) this.find(hql, userId, messageId).get(0);
		this.delete(collection);
	}

	@Override
	public void deleteAll() {
		
		String hql = "from Collection";
		List<Collection> collections = (List<Collection>) this.find(hql);
		for(Collection collection : collections){
			this.delete(collection);
		}
		
		
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
