package dao;


import java.util.List;

import entity.Category;

public interface CategoryDao {


	/**
	 * 添加分类
	 */
	public void insertCategoty(Category category);
	/**
	 * 更新分类
	 */
	public void updateCategoty(Category category);
	/**
	 * 查找分类
	 */
	public List selectCategoty(Category category);
	/**
	 * 通过id查找分类
	 * @param id
	 */
	public List selectCategotyById(int id);
	/**
	 * 删除分类
	 */
	public void deleteCategoty(Category category);
	/**
	 * 通过id删除分类
	 * 
	 */
	public void deleteCategotyById(int id);
	
	public void deleteAll();
		
	
}
