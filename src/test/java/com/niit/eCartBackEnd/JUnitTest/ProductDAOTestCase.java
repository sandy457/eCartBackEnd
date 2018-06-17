package com.niit.eCartBackEnd.JUnitTest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.eCartBackEnd.dao.ProductDAO;
import com.niit.eCartBackEnd.model.Product;

@SuppressWarnings("unused")
public class ProductDAOTestCase 
{
	@Autowired
	static ProductDAO productDAO;
	
	@Autowired
	static Product product;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.eCartBackEnd");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");
	}
	
//	@Test
	public void add()
	{
		product.setId("PLA_0101");
		product.setName("Plant0311");
		product.setPrice(500);
		product.setCategory_id("CAT_001");
		product.setSupplier_id("SUP_001");
		product.setDescription("Null");
		product.setStock(500);
		
		Assert.assertEquals("Add User", true, productDAO.addProduct(product));
		System.out.println("Product Added");
	}
	
//	@Test
	public void update()
	{
		product.setId("PLA_01031");
		product.setName("Plant050");
		product.setPrice(900);
		product.setCategory_id("CAT_001");
		product.setSupplier_id("SUP_001");
		product.setDescription("Null");
		product.setStock(500);
		
		Assert.assertEquals("Add User", true, productDAO.updateProduct(product));
		System.out.println("Product Updated");
	}
	
//	@Test
	public void delete()
	{
		Assert.assertEquals("Delete Product", true, productDAO.deleteProduct("PLA_0101"));
		System.out.println("Delete Function");	
	}
	
//	@Test
	public void list()
	{
		int size = productDAO.listProduct().size();
		int count = productDAO.listProduct().size();
		Assert.assertEquals("List user", count, size);
	}
	
//	@Test
	public void get()
	{
		Product product = productDAO.getProduct("PLA_01031");
		Assert.assertEquals("Get Product", "Plant050", product.getName());
		System.out.println("Get Function..");
	}

}
