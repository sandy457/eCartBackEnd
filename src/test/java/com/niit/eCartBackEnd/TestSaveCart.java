package com.niit.eCartBackEnd;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.eCartBackEnd.dao.SaveCartDAO;
import com.niit.eCartBackEnd.model.SaveCart;

public class TestSaveCart 
{
	@Autowired
	SaveCartDAO saveCartDAO;
	
	@Autowired
	SaveCart saveCart;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public TestSaveCart()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		saveCartDAO = (SaveCartDAO) context.getBean("saveCartDAO");
		saveCart = (SaveCart) context.getBean("saveCart");
	}

	public void add()
	{
		String bill_id = saveCartDAO.getBillId();
		saveCart.setBill_id(bill_id);
		saveCart.setMail_id("ko@gmail.com");
		saveCart.setProduct_id("FLW_001");
		saveCart.setQuantity(1);
		saveCart.setPrice(500);
		saveCartDAO.addSaveCart(saveCart);
		System.out.println("Add Success");
	}
	
	public void get()
	{
//		saveCart = saveCartDAO.getSavedCart("MHG-2017-01-26621c77c9-5288-4db4-85d8-8846b91c0ea5");
		List<SaveCart> list = saveCartDAO.getSavedCart("CartMHG-2017-01-28c09f69cf-bffc-4b12-8fb8-e747a6a574a8");
		int size = list.size();
		int i;
		for(i=0; i<size; i++)
			System.out.println("Check - "+list.get(i).getProduct_id()+" "+list.get(i).getQuantity());
	}
	
	public void getbyMail()
	{
		List<String> bills = saveCartDAO.getBills("chinz@gmail.com");
		int size = bills.size();
		for(int index = 0; index < size; index++)
			System.out.println("Check Bill "+index+" - "+bills.get(index)+"...");
	}
	
	public static void main(String[] args) 
	{
		TestSaveCart ts = new TestSaveCart();
//		ts.add();
		ts.get();
//		ts.getbyMail();
	}
}
