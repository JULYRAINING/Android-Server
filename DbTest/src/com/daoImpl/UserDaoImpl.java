package com.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import dao.UserDao;
import entity.Message;
import entity.UserDetail;
@Repository
public class UserDaoImpl extends HibernateTemplate implements UserDao {
	
	@Resource
	public SessionFactory sessionFactory;
	
	@Override
	public void insertUser(UserDetail userDetail) {
		this.saveOrUpdate(userDetail);
		
	}

	@Override
	public void updateUser(UserDetail userDetail) {
		this.saveOrUpdate(userDetail);
		
	}

	@Override
	public List selectUserById(int id) {
		String hql = "from UserDetail where id = ?";
		List<UserDetail> list = (List<UserDetail>) this.find(hql, id);
		
		return list;
	}

	@Override
	public List selectUserByName(String name) {
		String hql = "from UserDetail where name = ?";
		List<UserDetail> list = (List<UserDetail>) this.find(hql, name);
		
		return list;
	}

	@Override
	public void deleteUser(UserDetail userDetail) {
		this.delete(userDetail);
	}

	@Override
	public void deleteUserById(int id) {
		String hql = "from UserDetail where id = ?";
		UserDetail userDetail = (UserDetail) this.find(hql, id);
		this.delete(userDetail);
	}

	@Override
	public List selectAllUser() {
		String hql = "from UserDetail";
		List<UserDetail> list = (List<UserDetail>) this.find(hql);
		
		return list;
	}

	@Override
	public void deleteAll() {
		String hql = "from UserDetail";
		List<UserDetail> userDetails = (List<UserDetail>) this.find(hql);
		for(UserDetail userDetail : userDetails){
			this.delete(userDetail);
		}
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int selectUserIdByName(String name) {
		String hql = "select u.userId from UserDetail u where u.name = ?";
		ArrayList<Integer> idList = (ArrayList<Integer>) this.find(hql, name);
		if(idList.size() == 0){
			return -1;
		}else {
			int id = idList.get(0);
			return id;
		}
		
	}

	

}
