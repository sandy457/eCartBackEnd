package com.niit.eCartBackEnd.dao;

import java.util.List;

import com.niit.eCartBackEnd.model.Product;

public interface ProductDAO 
{
	
	public boolean addProduct(Product product);
	
	public boolean updateProduct(Product product);
	
	public boolean deleteProduct(String id);
	
	public List<Product> listProduct();
	
	public Product getProduct(String id);
}
