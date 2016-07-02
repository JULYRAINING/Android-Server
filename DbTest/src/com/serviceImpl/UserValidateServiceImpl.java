package com.serviceImpl;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

import dao.CategoryDao;
import dao.UserValidateDao;
import entity.UserValidate;
import service.UserValidateService;

@Service
public class UserValidateServiceImpl implements UserValidateService{

	@Resource
	public UserValidateDao userValidateDao;
	
	public UserValidateDao getUserValidateDao() {
		return userValidateDao;
	}

	public void setUserValidateDao(UserValidateDao userValidateDao) {
		this.userValidateDao = userValidateDao;
	}
	
	@Override
	public int addUserValidate(UserValidate userValidate) {
		
		return userValidateDao.insertUserValidate(userValidate);
		
	}

	@Override
	public String getSaltById(int id) {
		
		return userValidateDao.getSaltById(id);
	}

	@Override
	public boolean isValidate(int id, String password) {
		
		return userValidateDao.isValidate(id, password);
	}

	

	@Override
	public boolean isValidate(String name, String password) {
		
		return userValidateDao.isValidate(name, password);
	}

	

	

}
