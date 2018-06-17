package com.niit.eCartBackEnd.JUnitTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.eCartBackEnd.dao.SupplierDAO;
import com.niit.eCartBackEnd.model.Supplier;

import junit.framework.Assert;

@SuppressWarnings("unused")
public class SupplierDAOTestCase 
{
	@Autowired
	static SupplierDAO supplierDAO;
	
	@Autowired
	static Supplier supplier;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.eCartBackEnd");
		context.refresh();
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		supplier = (Supplier) context.getBean("supplier");
	}
	
//	@Test
	public void add()
	{
		supplier.setId("SUP_090");
		supplier.setName("SEA_MINING");
		supplier.setAddress("UDUPI.");
		Assert.assertEquals("Add Supplier", true, supplierDAO.addSupplier(supplier));
		System.out.println("Added");
	}
	
//	@Test
	public void update()
	{
		supplier.setId("SUP_001");
		supplier.setName("Lalbagh");
		supplier.setAddress("Lalbagh Botanical Garden, Bangalore");
		Assert.assertEquals("Update Fxn", true, supplierDAO.updateSupplier(supplier));
		System.out.println("updated");
	}

//	@Test
	public void delete()
	{
		Assert.assertEquals("Delete", true, supplierDAO.deleteSupplier("SUP_090"));
		System.out.println("Deleted");
	}
	
//	@Test
	public void list()
	{
		int size = supplierDAO.listSupplier().size();
		int count = supplierDAO.listSupplier().size();
		Assert.assertEquals("List", count, size);
		System.out.println("List");
	}
	
//	@Test
	public void get()
	{
		Supplier supplier = supplierDAO.getSupplier("SUP_001");
		Assert.assertEquals("Get Supplier", "Lalbagh", supplier.getName());
		System.out.println("Get Function..");
	}
}