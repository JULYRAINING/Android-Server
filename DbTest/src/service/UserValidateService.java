package service;

import entity.UserValidate;

public interface UserValidateService {

	public int addUserValidate(UserValidate userValidate);
	public String getSaltById(int id);
	public boolean isValidate(int id, String password);
	public boolean isValidate(String name, String password);
	

}
