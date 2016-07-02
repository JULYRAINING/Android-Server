package com.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import dao.CommentDao;
import entity.Category;
import entity.Comment;
import entity.Message;

public class CommentDaoImpl extends HibernateTemplate implements CommentDao {

	@Resource
	public SessionFactory sessionFactory;
	@Override
	public void insertComment(Comment comment) {
		this.save(comment);// TODO Auto-generated method stub

	}

	@Override
	public void updateComment(Comment comment) {
		this.saveOrUpdate(comment);
	}

	@Override
	public Comment selectCommentById(int id) {
		Comment comment = null;
		String hql = "from Comment where id =?";
		List list = this.find(hql, id);
		if(!list.isEmpty()){
			comment = (Comment) list.get(0);
		}
		return comment;
	}

	@Override
	public List selectCommentByExample(Comment comment) {
		return this.findByExample(comment);

	}

	@Override
	public void deleteComment(Comment comment) {
		this.delete(comment);

	}

	@Override
	public void deleteCommentById(int id) {
		String hql = "from Comment where id =?";
		Comment comment = (Comment) this.find(hql, id);
		this.delete(comment);

	}

	@Override
	public void deleteAll() {
		/*SessionFactory sessionFactory = this.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		String sql = "delete * from comment";
		Query query = session.createSQLQuery(sql);*/
		String hql = "from Comment";
		List<Comment> comments = (List<Comment>) this.find(hql);
		for(Comment comment : comments){
			this.delete(comment);
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Comment> selectAllByMessageId(int messageId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select * from Comment where messageId = "+messageId;
		

		//session.createSQLQuery(sql);
		Query query = session.createSQLQuery(sql).addEntity(Comment.class);
		
		ArrayList<Comment>list = (ArrayList<Comment>) query.list();
		
		return list;
	}

}
