package com.niit.eCartBackEnd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.eCartBackEnd.dao.BillingDAO;
import com.niit.eCartBackEnd.dao.PaymentDAO;
import com.niit.eCartBackEnd.model.Billing;
import com.niit.eCartBackEnd.model.Payment;

public class Bill_PayTesting
{

	private static final Logger log = LoggerFactory.getLogger(Bill_PayTesting.class);
	
	@Autowired
	BillingDAO billingDAO;
	
	@Autowired
	Billing billing;
	
	@Autowired
	Payment payment;
	
	@Autowired
	PaymentDAO paymentDAO;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public Bill_PayTesting()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		billingDAO = (BillingDAO) context.getBean("billingDAO");
		billing = (Billing) context.getBean("billing");
		
		paymentDAO = (PaymentDAO) context.getBean("paymentDAO");
		payment = (Payment) context.getBean("payment");
		
	}
	
	public void add()
	{
		billing.setMail_id("kk@roetmail.com");
		billing.setName("deadstone_kk");
		billing.setCc_no("1230456789452106");
		billing.setExp_month(02);
		billing.setExp_year(2018);
		billingDAO.addBilling(billing);
		System.out.println("data added");
		log.info("Data Added - Billing");
	}
	
	public void get()
	{
		billing = billingDAO.getBilling("kk@roetmail.com");
		System.out.println("Name - "+billing.getName());
	}
	
	public void savepay()
	{
		System.out.println("HI");
		payment.setF_name("Kaustubh");
		System.out.println("HI");
		payment.setL_name("Kallianpur");
		System.out.println("HI");
		payment.setMail_id("kk@rocketmail.com");
		payment.setMobile("7259292695");
		System.out.println("HI");
		payment.setSt_line1("72, 11th Main Road");
		payment.setSt_line2("Malleswaram");
		payment.setCity("Bangalore");
		payment.setState("Karnataka");
		payment.setZip_code(560003);
		paymentDAO.addPaymentInfo(payment);
		System.out.println("success");
		log.info("Data added - Payment");
	}
	
	public void getpay()
	{
		payment = paymentDAO.getPaymentInfo("kk@rocketmail.com");
		System.out.println("Name -"+payment.getF_name()+" "+payment.getL_name());
	}
	
	public static void main(String[] args) 
	{
		Bill_PayTesting bp = new Bill_PayTesting();
//		bp.add();
		bp.get();
//		bp.savepay();
		bp.getpay();
	}
}