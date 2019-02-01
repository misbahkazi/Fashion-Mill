package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.model.CartItem;

public class CartUnitTest {
	
static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	
	@Ignore
	@Test
	public void addCartTest()
	{
		CartItem cartItem=new CartItem();
		cartItem.setProductId(2);
		cartItem.setProductName("Gucci perfume");
		cartItem.setQuantity(2);
		cartItem.setPrice(5999);
		cartItem.setPaymentStatus("Pending");
		cartItem.setUsername("Alice");
		
		assertTrue("Problem in Adding to Cart" , cartDAO.addCartItem(cartItem));
	}
	
	
	@Ignore
	@Test 
	public void updateCartItemTest()
	{
		CartItem cartItem=cartDAO.getCartItem(2);
		cartItem.setQuantity(3);
		
		assertTrue("Problem in Updating the cart",cartDAO.updateCartItem(cartItem));
	}
	
	@Ignore
	@Test
	public void deleteCartItemTest()
	{
		CartItem cartItem=cartDAO.getCartItem(5);
		assertTrue("Problem in Deleting the cart",cartDAO.deleteCartItem(cartItem));
	}
	
	
	@Ignore
	@Test
	public void displayCartItem()
	{
		List<CartItem> listCartItems=cartDAO.listCartItems("Alice");
		assertTrue("Problem in Displaying the CartItems" , listCartItems.size()>0);
		
		
		for(CartItem cartItem:listCartItems)
		{
			System.out.print(cartItem.getProductId()+"\t");
			System.out.print(cartItem.getProductName()+"\t");
			System.out.print(cartItem.getPrice()+"\t");
			System.out.print(cartItem.getPrice()*cartItem.getQuantity());
		}
		
	}

}
