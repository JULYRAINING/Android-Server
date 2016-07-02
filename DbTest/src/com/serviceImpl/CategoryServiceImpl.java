package com.serviceImpl;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.CategoryDao;
import dao.UserDao;
import entity.Category;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	@Resource
	private CategoryDao categoryDao;
	
	@Override
	public void addCategory(Category category) {
		
		categoryDao.insertCategoty(category);// TODO Auto-generated method stub
		
	}
	@Override
	public Category getCategoryById(int id) {
		
		Category category = (Category) categoryDao.selectCategotyById(id).get(0);
		return category;
	}
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	
	@Override
	public void deleteAll() {
		
		
		categoryDao.deleteAll();
		
	}
	
	

}
