package com.niit.eCartBackEnd.dao;

import java.util.List;

import com.niit.eCartBackEnd.model.Supplier;

public interface SupplierDAO 
{
	public boolean addSupplier(Supplier supplier);

	public boolean updateSupplier(Supplier supplier);

	public boolean deleteSupplier(String id);
	
	public List<Supplier> listSupplier();
	
	public Supplier getSupplier(String id);
	
	public Supplier getByName(String name);
}
