package service;

import entity.Category;

public interface CategoryService {

	public void addCategory(Category category);
	public Category getCategoryById(int id);
	public void deleteAll();
}
