package com.daoImpl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import dao.TokenValidateDao;
import entity.TokenValidate;
import entity.UserDetail;

public class TokenValidateDaoImpl extends HibernateTemplate implements TokenValidateDao{
	@Resource
	public SessionFactory sessionFactory;
	
	
	@Override
	public void insertToken(TokenValidate tokenValidate) {
		this.save(tokenValidate);
		
	}

	@Override
	public TokenValidate selectToken(int id) {
		String hql = "from TokenValidate t where t.userId = ?";
		ArrayList<TokenValidate> tokenValidates = (ArrayList<TokenValidate>) this.find(hql, id);
		if(tokenValidates.size() == 0){
			return null;
		}else {
			TokenValidate tokenValidate = tokenValidates.get(0);
			
            return tokenValidate;
		}
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void deleteTokenById(int id) {
		String hql = "from TokenValidate where id = ?";
		ArrayList<TokenValidate> tokenValidates = (ArrayList<TokenValidate>) this.find(hql, id);
		if(tokenValidates.size() == 0){
			return;
		}else {
			TokenValidate tokenValidate = tokenValidates.get(0);
			this.delete(tokenValidate);
			
		}
		
	}

}
