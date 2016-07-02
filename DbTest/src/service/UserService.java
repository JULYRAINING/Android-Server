package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import entity.UserDetail;

public interface UserService {

	
	
	public void addUser(UserDetail user);
	public void updateUser(int id,UserDetail user);
	public UserDetail getUserById(int id);
	public void deleteAll();
	public int getUserIdByName(String name);
	
}
