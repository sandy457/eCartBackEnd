package com.niit.eCartBackEnd.JUnitTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.eCartBackEnd.dao.CategoryDAO;
import com.niit.eCartBackEnd.model.Category;

import junit.framework.Assert;

@SuppressWarnings("unused")
public class CategoryDAOTestCase 
{
	@Autowired
	static CategoryDAO categoryDAO;
	
	@Autowired
	static Category category;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.eCartBackEnd");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
	}
//	@Test
	public void add()
	{
		category.setId("CAT_090");
		category.setName("ROCK");
		category.setDescription("Beautiful Pebbles for your backyard.");
		Assert.assertEquals("Add Category", true, categoryDAO.addCategory(category));
		System.out.println("Added");
	}
	
//	@Test
	public void update()
	{
		category.setId("CAT_001");
		category.setName("SEEDS");
		category.setDescription("NULL");
		Assert.assertEquals("Update Fxn", true, categoryDAO.updateCategory(category));
		System.out.println("updated");
	}

//	@Test
	public void delete()
	{
		Assert.assertEquals("Delete", true, categoryDAO.deleteCategory("CAT_090"));
		System.out.println("Deleted");
	}
	
//	@Test
	public void list()
	{
		int size = categoryDAO.listCategory().size();
		int count = categoryDAO.listCategory().size();
		Assert.assertEquals("List", count, size);
		System.out.println("List");
	}

//	@Test
	public void get()
	{
		Category category = categoryDAO.getCategory("CAT_001");
		Assert.assertEquals("Get Category", "SEEDS", category.getName());
		System.out.println("Get Function..");
	}
}
