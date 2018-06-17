package com.niit.eCartBackEnd.dao;

import com.niit.eCartBackEnd.model.Billing;

public interface BillingDAO 
{
	public boolean addBilling(Billing billing);
	
	public Billing getBilling(String mail_id);
	
	public String generateID();
}
