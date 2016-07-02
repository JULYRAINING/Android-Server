package com.daoImpl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import antlr.collections.List;
import dao.UserValidateDao;
import entity.UserValidate;
import utils.MD5Convert;
@Repository
public class UserValidateDaoImpl extends HibernateTemplate implements UserValidateDao{
	@Resource
	public SessionFactory sessionFactory;
	
	
	@Override
	public int insertUserValidate(UserValidate userValidate) {
		return (int) this.save(userValidate);// TODO Auto-generated method stub
		
	}

	@Override
	public String getSaltById(int id) {
		String hql = "select u.salt from UserValidate u where u.userSecurityId = ?";
		
		
		ArrayList<String> saltList = (ArrayList<String>) this.find(hql, id);
		if (saltList.size()==0) {
			return null;
		}
		
		String salt = saltList.get(0);
		return salt;
	}

	@Override
	public boolean isValidate(int id, String password) {
		
		String hql_password = "select u.password from UserValidate u where u.userSecurityId = ?";
		String hql_salt = "select u.salt from UserValidate u where u.userSecurityId = ?";

		
		ArrayList<String> passwordList = (ArrayList<String>) this.find(hql_password, id);
		if (passwordList.size()==0) {
			return false;
		}
		ArrayList<String> saltList = (ArrayList<String>) this.find(hql_salt, id);
		if (saltList.size()==0) {
			return false;
		}
		
		
		String dbPwd = passwordList.get(0);
		String dbSalt = saltList.get(0);
		
		String pwd = MD5Convert.getMd5(password.concat(dbSalt));
		
		return pwd.equals(dbPwd);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean isValidate(String name, String password) {
		
		String hql_userId = "select u.userId from UserDetail u where u.name = ?";
		ArrayList<Integer> userIdList = (ArrayList<Integer>) this.find(hql_userId, name);
		if(userIdList.size() == 0){
			return false;
		}
		int userId = userIdList.get(0);
		
		String hql_password = "select u.password from UserValidate u where u.userSecurityId = ?";
				
		
		String hql_salt = "select u.salt from UserValidate u where u.userSecurityId = ?";
		
		
		ArrayList<String> passwordList = (ArrayList<String>) this.find(hql_password, userId);
		if (passwordList.size()==0) {
			return false;
		}
		ArrayList<String> saltList = (ArrayList<String>) this.find(hql_salt, userId);
		if (saltList.size()==0) {
			return false;
		}
		String dbPwd = passwordList.get(0);
		String dbSalt = saltList.get(0);
		
		String pwd = MD5Convert.getMd5(password.concat(dbSalt));
		
		return pwd.equals(dbPwd);
	}

	

}
