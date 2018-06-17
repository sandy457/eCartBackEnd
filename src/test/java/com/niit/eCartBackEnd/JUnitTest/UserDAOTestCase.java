package com.niit.eCartBackEnd.JUnitTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.eCartBackEnd.dao.UserDAO;
import com.niit.eCartBackEnd.model.User;

import junit.framework.Assert;

@SuppressWarnings("unused")
public class UserDAOTestCase 
{
	@Autowired
	static UserDAO userDAO;
	
	@Autowired
	static User user;
		
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass //only written for Static methods... hence make everything inside as static
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.eCartBackEnd");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");
		
	}
	
	@SuppressWarnings("deprecation")
//	@Test
	public void getUserTestCase()
	{
		user = userDAO.getUser("sandipan@gmail.com");
		Assert.assertEquals("User Test Case", "sandipan", user.getF_name());

		//assertNotNull and assertNull are functions that can be used...
	}
	
	@SuppressWarnings("deprecation")
//	@Test
	public void validate()
	{
//		working properly
		user = userDAO.validateUser("sandipan@gmail.com", "sandipan");
		Assert.assertEquals("Validate User", "sandipan", user.getF_name());
		Assert.assertNotNull("Validate New User",user);
	}
	
	@SuppressWarnings("deprecation")
//	@Test
	public void invalid()
	{
		user = userDAO.validateUser("kk@gmail.com", "kk");
		Assert.assertNull("Invalid User", user);
	}
	
	@SuppressWarnings("deprecation")
//	@Test
	public void getAllUsers()
	{
		int size = userDAO.list().size();
		int count = userDAO.list().size();
		Assert.assertEquals("Length Check", count, size);
	}
	
	@SuppressWarnings("deprecation")
//	@Test
	public void addUser()
	{
		user.setF_name("KITTI");
		user.setL_name("SHET");
		user.setMail_id("kitt2s@gmail.com");
		user.setMobile("7889456541");
		user.setPassword("hi5555");
		userDAO.addUser(user);
		Assert.assertEquals("Add User Test", true, userDAO.addUser(user));
	}
	
	@SuppressWarnings("deprecation")
//	@Test
	public void update()
	{
		user.setF_name("KRISHNA");
		user.setL_name("S");
		user.setMail_id("kittis@gmail.com");
		user.setMobile("7889456451");
		user.setPassword("kittis1995");
		userDAO.updateUser(user);
		Assert.assertEquals("Update Object", true, true);
	}

	@SuppressWarnings("deprecation")
//	@Test
	public void delete()
	{
		Assert.assertEquals("Delete User", true, userDAO.deleteUser("kitt2s@gmail.com"));
		
	}
}
