package dao;


import java.util.List;

import entity.UserDetail;

public interface UserDao {

	/**
	 * ����û�
	 */
	public void insertUser(UserDetail userDetail);
	/**
	 * �����û�
	 */
	public void updateUser(UserDetail userDetail);
	/**
	 * ͨ��id�����û�
	 */
	public List selectUserById(int id);
	/**
	 * ͨ��name�����û�
	 * @param name
	 */
	public List selectUserByName(String name);
	public int selectUserIdByName(String name);
	/**
	 * ɾ���û�
	 */
	public void deleteUser(UserDetail userDetail);
	/**
	 * ɾ���û�
	 */
	public void deleteUserById(int id);
	
	public List selectAllUser();
	public void deleteAll();
}
