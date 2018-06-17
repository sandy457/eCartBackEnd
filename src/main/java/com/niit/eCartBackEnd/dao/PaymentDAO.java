package com.niit.eCartBackEnd.dao;

import com.niit.eCartBackEnd.model.Payment;

public interface PaymentDAO 
{

	public boolean addPaymentInfo(Payment payment);
	
	public Payment getPaymentInfo(String mail_id);
}
