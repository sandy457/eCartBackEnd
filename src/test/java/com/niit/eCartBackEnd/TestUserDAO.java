package com.niit.eCartBackEnd;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.eCartBackEnd.dao.UserDAO;
import com.niit.eCartBackEnd.model.User;

public class TestUserDAO
{
	Logger log = LoggerFactory.getLogger(TestUserDAO.class);
			
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	User user;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public TestUserDAO()
	{
		//create instance only for system defined method.
		context = new AnnotationConfigApplicationContext();
		//specify the packages... / context will scan for annotations like
		//@component, @repository... etc.
		context.scan("com.niit.eCartBackEnd");
		context.refresh();
		// context -> Bean Factory.. if instance is there it will return, else it will return null..\
		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");
		
	}
	
	public boolean validate(String id, String password)
	{
		log.debug("Starting of method validate user");
		if(userDAO.validateUser(id, password) == null)
		{
			System.out.println("Invalid Credentials");
			log.debug("Invalid Credentials");
			return false;
			}
		else
		{
			System.out.println("Welcome "+id);
			log.debug("Valid Credentials");
			return true;
		}
	}
	
	public void add()
	{
		log.debug("Starting of method Add User");
		user.setF_name("VARUN");
		user.setL_name("S");
		user.setMail_id("varu@gmail.com");
		user.setMobile("7259695987");
		user.setPassword("unknown55");
		userDAO.addUser(user);
		log.debug("Ending of method Add user");
	}
	
	public void update()
	{
		log.debug("Starting of method Update");
		user.setF_name("RAHUL");
		user.setL_name("KUMAR");
		user.setMail_id("rahul@gmail.com");
		user.setMobile("9873146798");
		user.setPassword("123rahul");
		userDAO.updateUser(user);
		log.debug("Ending of method update");
	}
	
	public void userList()
	{
		log.debug("Starting of method userList");
		List<User> u = userDAO.list();
		for(User test : u)
		{
			System.out.println(test.getF_name()+" "+test.getL_name()+"\t"+test.getMail_id()+"\t "+test.getMobile());
		}
		log.debug("Ending of method userList");
	}
	
	public void delete()
	{
		log.debug("Starting od method Delete");
		String id = "example@gmail.com";
		userDAO.deleteUser(id);
		log.debug("Ending of method Delete");
	}
	
	public void getUser()
	{
		log.debug("Starting of method getUser");
		String id = "kaustubh@gmail.com";
		user = userDAO.getUser(id);
		System.out.println(user.getF_name());
		log.debug("Ending of method getUser");
	}
	
	public static void main(String[] args) 
	{
		TestUserDAO t = new TestUserDAO();
//		t.validate("rahul@gmail.com", "123rahul");
//		t.add();
//		t.update();
//		t.userList();
		t.delete();
//		t.getUser();
		
	}
}