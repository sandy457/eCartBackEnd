package com.niit.eCartBackEnd;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.eCartBackEnd.dao.SupplierDAO;
import com.niit.eCartBackEnd.model.Supplier;

public class TestSupplierDAO 
{
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	AnnotationConfigApplicationContext context;

	public TestSupplierDAO()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.eCartBackEnd");
		context.refresh();
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		supplier = (Supplier) context.getBean("supplier");
		
	}
	
	public void add()
	{
		supplier.setId("SUP_001");
		supplier.setName("Lalbagh Nursery");
		supplier.setAddress("Lalbagh Botanical Garden, Bangalore");
		supplierDAO.addSupplier(supplier);
		System.out.println("Supplier Added");
	}
	
	public void update()
	{
		supplier.setId("SUP_001");
		supplier.setName("Kaustubh Nursery");
		supplier.setAddress("Malleswaram");
		supplierDAO.updateSupplier(supplier);
		System.out.println("Supplier Updated");
	}
	
	public void listSupplier()
	{
		List<Supplier> s = supplierDAO.listSupplier();
		for(Supplier test : s)
		{
			System.out.println(test.getId()+"\t\t"+test.getName()+"\t\t"+test.getAddress());
		}
	}
	
	public void delete()
	{
		supplierDAO.deleteSupplier("test");
		System.out.println("Success delete");
	}
	
	public void get()
	{
		String id = "SUP_001";
		Supplier supplier = supplierDAO.getSupplier(id);
		System.out.println("Supplier Name: "+supplier.getName());
	}
	
	public void getName()
	{
		String id = "SEA_MINING";
		Supplier supplier = supplierDAO.getByName(id);
		System.out.println("Supplier Name: "+supplier.getName()+" log");
	}
	
	public static void main(String[] args) 
	{
		TestSupplierDAO ts = new TestSupplierDAO();
//		ts.add();
		ts.delete();
//		ts.update();
//		ts.listSupplier();
//		ts.get();
//		ts.getName();		
	}
}
