package com.niit.eCartBackEnd.dao;

import java.util.List;

import com.niit.eCartBackEnd.model.Category;

public interface CategoryDAO 
{
	public boolean addCategory(Category category);
	
	public boolean updateCategory(Category category);
	
	public boolean deleteCategory(String id);
	
	public List<Category> listCategory();
	
	public Category getCategory(String id);
	
	public Category getByName(String name);
}
