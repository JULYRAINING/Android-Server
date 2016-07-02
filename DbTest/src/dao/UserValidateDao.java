package dao;

import entity.UserValidate;

public interface UserValidateDao {
	public int insertUserValidate(UserValidate userValidate);
	public String getSaltById(int id);
	public boolean isValidate(int id, String password);
	public boolean isValidate(String name, String password);
	

}
