package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.OrderDAO;
import com.niit.model.OrderDetail;

public class OrderUnitTest {

	
	
static OrderDAO orderDAO;
	
	@BeforeClass
	public static void executeFirst() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		orderDAO = (OrderDAO)context.getBean("orderDAO");
	}
	
	
	@Test
	@Ignore
	  public void saveOrderTest()
	  {
		OrderDetail orderDetail= new OrderDetail();
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setCartId(100);
		orderDetail.setShippingAddr("Goa");
		orderDetail.setPaymentMode("COD");
		orderDetail.setUsername("Alice");
		
		assertTrue("Problem in Saving Order", orderDAO.saveOrder(orderDetail));
	  }
		
}



