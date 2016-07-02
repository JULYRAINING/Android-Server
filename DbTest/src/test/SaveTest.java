package test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sun.xml.internal.ws.resources.AddressingMessages;

import entity.Category;
import entity.Collection;
import entity.Comment;
import entity.Message;
import entity.UserDetail;
import hibernate.HibernateSessionFactory;

public class SaveTest {

	@Test
	public void save() {
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Category category = new Category();
		category.setCategoryId(149);
		category.setName("����");
		category.setDescription("�������");
		session.save(category);
		tx.commit();
	}

	@Test
	public void print() {
		System.out.println("123");
	}

	@Test
	public void saveMessage() {
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		UserDetail user = new UserDetail();
		user.setGender(0);
		user.setGrade(3);
		user.setImage("123456");
		user.setMajor("����ѧ");
		user.setMinor("MBA");
		user.setName("����");
		user.setSignature("��ʲô���������һ����һ��Ļ�ϲ");
		user.setUserId(137);
		// �����û�
		session.save(user);
		System.out.println("������һ���û���¼");
		Category category = new Category();
		category.setCategoryId(169);
		category.setName("����");
		category.setDescription("�������");
		// �������
		session.save(category);
		System.out.println("������һ�������¼");
		for (int i = 1; i < 700; i++) {
			Message message = new Message();
			message.setMessageId(i);
			message.setCategory(category);
			message.setApprove(12);
			message.setContent(i+"life is always hard");
			message.setImage("path");
			message.setIsDelete(0);
			message.setOppose(13);
			message.setTime(new Date());
			message.setUser(user);
			session.save(message);
		}
		System.out.println("���������¼�¼");

		tx.commit();
	}

	@Test
	public void AddMessages(){
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql_find_user = "from UserDetail where userId = 137";
		String hql_find_category = "from Category where categoryId = 169";

		
		Query queryUser = session.createQuery(hql_find_user);
		Query queryCategory = session.createQuery(hql_find_category);

		
		UserDetail user = (UserDetail) queryUser.list().get(0);
		Category category = (Category) queryCategory.list().get(0);
		
		for (int i = 1; i < 700; i++) {
			Message message = new Message();
			message.setMessageId(i);
			message.setCategory(category);
			message.setApprove(12);
			message.setContent(i+"��������˵����ᣬ��˵Ľ�����������ȥѡ�񣬾��Ѿ���");
			message.setImage("[{\"Image\":\"1455184290089\"}]");
			message.setIsDelete(0);
			message.setOppose(13);
			message.setTime(new Date());
			message.setUser(user);
			session.save(message);
		}
		System.out.println("���������¼�¼");
		
		
		
		tx.commit();
	}
	@Test
	public void select() {
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Category where category_id = 169";
		List list = session.createQuery(hql).list();
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			Category cc = (Category) iter.next();
			System.out.println(cc.getMessages().size());
		}
		tx.commit();
	}

	@Test
	public void delete() {
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		String hql_3 = "delete Message";
		Query query_3 = session.createQuery(hql_3);
		int count_3 = query_3.executeUpdate();
		System.out.println("ɾ����" + count_3 + "�����¼�¼");

		String hql_1 = "delete UserDetail";
		Query query_1 = session.createQuery(hql_1);
		int count_1 = query_1.executeUpdate();
		System.out.println("ɾ����" + count_1 + "���û���¼");

		String hql_2 = "delete Category";
		Query query_2 = session.createQuery(hql_2);
		int count_2 = query_2.executeUpdate();
		System.out.println("ɾ����" + count_2 + "�������¼");
		
		String hql_4 = "delete Collection";
		Query query_4 = session.createQuery(hql_4);
		int count_4 = query_4.executeUpdate();
		System.out.println("ɾ����" + count_4 + "���ղؼ�¼");
		
		tx.commit();

	}

	@Test
	public void addComment() {
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql1 = "from UserDetail as user where user.userId = 137";
		Query query1 = session.createQuery(hql1);
		List list1 = query1.list();
		UserDetail user = (UserDetail) list1.get(0);

		String hql2 = "from Message as message where message.messageId = 3";
		Query query2 = session.createQuery(hql2);
		List list2 = query2.list();

		Message message = (Message) list2.get(0);

		Comment comment = new Comment();
		comment.setCommentId(1);
		comment.setMessage(message);
		comment.setUser(user);
		comment.setContent("������������");
		comment.setRefComment(null);
		session.save(comment);
		tx.commit();

	}

	@Test
	public void addCollection() {
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hql1 = "from UserDetail as user where user.userId = 137";
		Query query1 = session.createQuery(hql1);
		List list1 = query1.list();
		UserDetail user = (UserDetail) list1.get(0);

		String hql2 = "from Message as message where message.messageId = 3";
		Query query2 = session.createQuery(hql2);
		List list2 = query2.list();
		Message message = (Message) list2.get(0);
		
		Collection collection = new Collection();
		collection.setId(777);
		collection.setMessage(message);
		collection.setUser(user);
		collection.setTime(new Date());
		session.save(collection);
		tx.commit();

	}
	@Test
	public void getMessage(){
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "from Message where messageId between 600 and 610";
		
		Query query = session.createQuery(hql);
		
		query.setMaxResults(3);
		
		List list = query.list();
		
		System.out.println(list.size());
		
		tx.commit();
	}
}
