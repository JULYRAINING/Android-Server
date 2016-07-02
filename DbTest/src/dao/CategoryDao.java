package dao;


import java.util.List;

import entity.Category;

public interface CategoryDao {


	/**
	 * ��ӷ���
	 */
	public void insertCategoty(Category category);
	/**
	 * ���·���
	 */
	public void updateCategoty(Category category);
	/**
	 * ���ҷ���
	 */
	public List selectCategoty(Category category);
	/**
	 * ͨ��id���ҷ���
	 * @param id
	 */
	public List selectCategotyById(int id);
	/**
	 * ɾ������
	 */
	public void deleteCategoty(Category category);
	/**
	 * ͨ��idɾ������
	 * 
	 */
	public void deleteCategotyById(int id);
	
	public void deleteAll();
		
	
}
