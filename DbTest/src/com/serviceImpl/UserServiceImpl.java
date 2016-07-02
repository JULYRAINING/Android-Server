package com.serviceImpl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;
import dao.UserDao;
import entity.UserDetail;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Test
	@Override
	public void addUser(UserDetail user) {

		

		
		
		userDao.insertUser(user);

	}
	@Test
	public void updateUser(int id,UserDetail user){
		

		UserDetail Puser =  (UserDetail) userDao.selectUserById(id).get(0);
		Puser.setGender(user.getGender());
		Puser.setGrade(user.getGrade());
		Puser.setImage(user.getImage());
		Puser.setMajor(user.getMajor());
		Puser.setMinor(user.getMinor());
		Puser.setName(user.getName());
		Puser.setSignature(user.getSignature());
		
		userDao.updateUser(user);
	}
	@Override
	public UserDetail getUserById(int id) {
		
		ArrayList<UserDetail> userDetailList = (ArrayList<UserDetail>) userDao.selectUserById(id);
		if(userDetailList.size() == 0){
			return null;
		}else {
			UserDetail userDetail = userDetailList.get(0);
			return userDetail;
		}
		
		
	}

 	public void setUserDao(UserDao userDao) {
		// TODO Auto-generated method stub

	}
	@Override
	public void deleteAll() {
		
		userDao.deleteAll();
	}
	@Override
	public int getUserIdByName(String name) {
		
		return userDao.selectUserIdByName(name);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	

}
