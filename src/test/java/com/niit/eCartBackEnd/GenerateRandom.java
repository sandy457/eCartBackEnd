package com.niit.eCartBackEnd;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class GenerateRandom
{
	public String random()
	{
		String uuid;
		uuid = UUID.randomUUID().toString();
		return uuid;
	}
	
	public String date()
	{
		@SuppressWarnings("unused")
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy_MM_dd");
		String localDate = LocalDate.now().toString();
		return localDate;
	}
	
	public static void main(String[] args) 
	{
		GenerateRandom ob = new GenerateRandom();
		String name = ob.random();
		String id = ob.date();
		System.out.println("UUID = "+id+name);
	}
}
