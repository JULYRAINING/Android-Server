package com.daoImpl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;

import dao.CategoryDao;
import entity.Category;

public class CategoryDaoImpl extends HibernateTemplate implements CategoryDao {

	@Override
	public void insertCategoty(Category category) {
		this.save(category);

	}

	@Override
	public void updateCategoty(Category category) {
		this.saveOrUpdate(category);

	}

	@Override
	public List selectCategoty(Category category) {
		return this.findByExample(category);
	}

	@Override
	public List selectCategotyById(int id) {
		String hql = "from Category where id = ?";
		List<Category> list = (List<Category>) this.find(hql, id);
		
		return list;
	}

	@Override
	public void deleteCategoty(Category category) {
		this.delete(category);
	}

	@Override
	public void deleteCategotyById(int id) {
		String hql = "from Category where id = ?";
		Category category = (Category) this.find(hql, id);
		
		this.delete(category);
	}

	@Override
	public void deleteAll() {
		
		
		Session session = this.getSessionFactory().openSession();
		session.setFlushMode(FlushMode.AUTO);
	
		String hql = "delete from category where 1=1";
		Query query = session.createSQLQuery(hql);
		
		query.executeUpdate();
		
		
		
		
	}

}
