package com.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Embeddable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import dao.MessageDao;
import entity.Collection;
import entity.Comment;
import entity.Message;
import hibernate.HibernateSessionFactory;

@Repository
public class MessageDaoImpl extends HibernateTemplate implements MessageDao {

	@Resource
	public SessionFactory sessionFactory;
	
	@Override
	public void insertMessage(Message message) {
		this.save(message);
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMessage(Message message) {
		this.saveOrUpdate(message);// TODO Auto-generated method stub

	}

	@Override
	public List selectMessageById(int id) {
		String hql = "from Message where id =?";
		List list = this.find(hql, id);
		return list;
	}

	@Override
	public List selectMessageByTitle(String title) {
		String hql = "from Message where title =?";
		List list = this.find(hql, title);
		return list;
	}

	@Override
	public void deleteMessageById(int id) {
		String hql = "from Message where id =?";
		Message message = (Message) this.find(hql, id);
		this.delete(message);
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMessage(Message message) {
		this.delete(message);
	}

	@Override
	public void deleteAll() {
		String hql = "from Message";
		List<Message> messages = (List<Message>) this.find(hql);
		for(Message message : messages){
			this.delete(message);
		}
		
	}

	@Override
	public List selectMessage() {
		String hql = "from Message";
		List<Message> messages = (List<Message>) this.find(hql);
		return messages;
	}

	@Override
	public List selectMessageByUserId(int id) {
		String hql = "from Message m where m.user.userId = ?";
		List<Message> messages = (List<Message>) this.find(hql, id);
		return messages;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List selectMessageStartAtId(int id) {
		
		int recordLength = 2;
		String hql = "from Message";
//		List list = this.find(hql, id, recordLength);
		List list = this.find(hql);

		return list;
	}

	@Override
	public List selectMessageToDownToId(int id) {
		
		//-1表示查询最新的message
		String hql = null;
		List list = null;
		if(id!=-1){
			hql = "from Message where messageId < ? order by messageId desc";
			list = this.find(hql, id);

		}else{
			hql = "from Message order by messageId desc";
			list = this.find(hql);

		}

		
		
		System.out.println(list.size());
		
		List testList = new ArrayList<>();
		
		if(list.size()!=0){
			for(int i = 0; i<5;i++){
				testList.add(list.get(i));
			}
			

		}
		
		return testList;
	}

	/**
	 * 
	 * @param id 客户端储存的最大id 返回时应以此为界限
	 * @return
	 */
	@Override
	public List selectNewMessageToId(int id) {
		
		System.out.println("MessageDaoImpl selectNewMessageToId "+id);
		String hql = "from Message where messageId > ? order by messageId desc";
		this.setMaxResults(20);
		List list = this.find(hql, id);
		
		
		System.out.println("MessageDaoImpl selectNewMessageToId list size:"+list.size());
		return list;
	}

	/**
	 * 根据id范围来返回message 从大到小查询
	 * @param startId 最大id
	 * @param endId 最小id
	 * @return
	 */
	@Override
	public List selectOlderMessage(int startId, int endId) {
		System.out.println("MessageDaoImpl selectOlderMessage startId:"+startId+" endId:"+endId);
		String hql = "from Message where messageId between ? and ? order by messageId desc";
		List list = this.find(hql, endId, startId+1);
		System.out.println("MessageDaoImpl selectOlderMessage list size:"+list.size());
		return list;
	}

}
