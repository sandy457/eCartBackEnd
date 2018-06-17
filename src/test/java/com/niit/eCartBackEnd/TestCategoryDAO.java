package com.niit.eCartBackEnd;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.eCartBackEnd.dao.CategoryDAO;
import com.niit.eCartBackEnd.model.Category;

public class TestCategoryDAO 
{
	private static final Logger log = LoggerFactory.getLogger(TestCategoryDAO.class);
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	@Autowired
	AnnotationConfigApplicationContext context;

	public TestCategoryDAO()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.eCartBackEnd");
		context.refresh();
	
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
	}
	
	public void add()
	{
		category.setId("CAT_001");
		category.setName("PLANT SEEDS");
		category.setDescription("");
		categoryDAO.addCategory(category);
	}
	
	public void update()
	{
		category.setId(",kick");
		category.setName("SEEDS");
		category.setDescription("WEEDS, grows fast in your backyard.");
		categoryDAO.updateCategory(category);
		System.out.println("Success Update");
	}
	
	public void delete()
	{	
		String id = "CAT_008";
		categoryDAO.deleteCategory(id);
		System.out.println("Success delete");
	}
	
	public void listCategory()
	{
		List<Category> c = categoryDAO.listCategory();
		for(Category test : c)
		{
			System.out.println(test.getId()+"\t\t"+test.getName()+"\t\t"+test.getDescription());
		}
	}
	
	public void get()
	{
		log.debug("Starting of method: Get");
		String id = "CAT_001";
		Category category = categoryDAO.getCategory(id);
		System.out.println("Category Name "+category.getName());
		log.debug("Ending of method: Get");
	}
	
	public void getName()
	{
		log.debug("Starting of method: Get");
		String name = "PLANT SEEDS";
		Category category = categoryDAO.getByName(name);
		System.out.println("Category Name "+category.getName());
		log.debug("Ending of method: Get");
	}
	
	public static void main(String[] args) 
	{
		TestCategoryDAO tc = new TestCategoryDAO();
//		tc.listCategory();
//		tc.update();
//		tc.getName();
		tc.delete();
//		tc.get();
	}
}
