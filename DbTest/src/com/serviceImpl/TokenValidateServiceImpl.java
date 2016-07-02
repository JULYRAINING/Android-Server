package com.serviceImpl;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import dao.TokenValidateDao;
import entity.TokenValidate;
import service.TokenValidateService;


public class TokenValidateServiceImpl implements TokenValidateService{

	
	public TokenValidateDao tokenValidateDao;
	@Override
	public void addTokenValidate(TokenValidate tokenValidate) {
		ApplicationContext actx = new FileSystemXmlApplicationContext("classpath:springConfig.xml");
		tokenValidateDao = (TokenValidateDao) actx.getBean("tokenValidateDao");
		tokenValidateDao.insertToken(tokenValidate);
		
	}

	@Override
	public TokenValidate getTokenValidate(int id) {
		ApplicationContext actx = new FileSystemXmlApplicationContext("classpath:springConfig.xml");
		tokenValidateDao = (TokenValidateDao) actx.getBean("tokenValidateDao");
		return tokenValidateDao.selectToken(id);
	}

	public TokenValidateDao getTokenValidateDao() {
		return tokenValidateDao;
	}

	public void setTokenValidateDao(TokenValidateDao tokenValidateDao) {
		this.tokenValidateDao = tokenValidateDao;
	}

	@Override
	public void deleteTokenValidateById(int id) {
		ApplicationContext actx = new FileSystemXmlApplicationContext("classpath:springConfig.xml");
		tokenValidateDao = (TokenValidateDao) actx.getBean("tokenValidateDao");
		tokenValidateDao.deleteTokenById(id);
	}

}
