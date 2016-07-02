package dao;


import java.util.List;

import entity.UserDetail;

public interface UserDao {

	/**
	 * 添加用户
	 */
	public void insertUser(UserDetail userDetail);
	/**
	 * 更新用户
	 */
	public void updateUser(UserDetail userDetail);
	/**
	 * 通过id查找用户
	 */
	public List selectUserById(int id);
	/**
	 * 通过name查找用户
	 * @param name
	 */
	public List selectUserByName(String name);
	public int selectUserIdByName(String name);
	/**
	 * 删除用户
	 */
	public void deleteUser(UserDetail userDetail);
	/**
	 * 删除用户
	 */
	public void deleteUserById(int id);
	
	public List selectAllUser();
	public void deleteAll();
}
