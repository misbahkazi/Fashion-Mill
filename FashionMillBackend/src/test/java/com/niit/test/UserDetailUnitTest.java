package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDetailDAO;
import com.niit.model.Category;
import com.niit.model.UserDetail;

public class UserDetailUnitTest {

	static UserDetailDAO userDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();	
		userDAO=(UserDetailDAO)context.getBean("userDAO");
	}
	@Ignore
	@Test
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
		
		user.setUsername("Alice");
		user.setPassword("1120433");
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		user.setCustomerName("Alice James");
		user.setCustomerAddr("Goa");
		
		assertTrue("Problem in adding User:",userDAO.registerUser(user));
	}
	
	@Ignore
	@Test
	public void deleteUserTest()
	{
		UserDetail user=userDAO.getUser("Alice");
		assertTrue("Problem in Deleting user:",userDAO.deleteUser(user));
	}
	
	@Ignore
	@Test
	public void updateUserDetailTest()
	{
		UserDetail user=userDAO.getUser("Alice");
		user.setCustomerAddr("Mumbai");
		assertTrue("Problem in Updating the user",userDAO.updateAddress(user));
	}
	
	
	}

