package com.niit.eCartBackEnd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.eCartBackEnd.dao.ProductDAO;
import com.niit.eCartBackEnd.model.Product;

public class TestProductDAO 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public TestProductDAO()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.eCartBackEnd");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");
	}

	public void add()
	{
		product.setId("PRO_1521");
		product.setName("PRODUCT 1");
		product.setPrice(50000);
		product.setDescription("FIRST PRODUCT");
		product.setCategory_id("CAT_002");
		product.setSupplier_id("SUP_001");
		product.setStock(365);
		productDAO.addProduct(product);
		System.out.println("Product Added");
	}
	
	public void update()
	{
		product.setId("PRO_101");
		product.setName("PRODUCT 1002");
		product.setPrice(25000);
		product.setDescription("FIRST_PRODUCT FROM ME");
		product.setCategory_id("CAT_002");
		product.setSupplier_id("SUP_001");
		product.setStock(400);
		productDAO.updateProduct(product);
		System.out.println("Product updated");
	}
	
	public void list()
	{
		List<Product> p = productDAO.listProduct();
		for(Product test : p)
			System.out.println(test.getId()+" "+test.getName()+" "+test.getPrice()+" "+test.getStock());
	}
	
	public void delete()
	{
		productDAO.deleteProduct("PRO_1521");
		System.out.println("Sucess Delete");
	}

	public void get()
	{
		String id = "PLA_0101";
		Product product = productDAO.getProduct(id);
		System.out.println("Category Name "+product.getName());
	}
	
	public static void main(String[] args) 
	{
		TestProductDAO test = new TestProductDAO();
//		test.delete();
//		test.add();
//		test.update();
//		test.list();
		test.get();
	}
}
