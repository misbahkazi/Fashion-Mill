package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

public class ProductUnitTest 
{
	static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();	
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	//@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Gucci perfume");
		product.setProductDesc("Gucci womens perfume");
		product.setPrice(5999);
		product.setStock(20);
		product.setCategoryId(1);
		product.setSupplierId(102);
		
		assertTrue("Problem in Adding Product:",productDAO.addProduct(product));
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(5);
		assertTrue("Problem in Deleting Product:",productDAO.deleteProduct(product));
	}
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(8);
		product.setProductDesc("Gucci mens perfume");
		assertTrue("Problem in Updating the product",productDAO.updateProduct(product));
	}
	@Ignore
	@Test
	public void listProductsTest()
	{
		List<Product> listProducts=productDAO.listProducts();
		assertTrue("Problem in Listing Products:",listProducts.size()>0);
		
		for(Product product:listProducts)
		{
			System.out.println("Product ID:"+product.getProductId());
			System.out.println("Product Name:"+product.getProductName());
			System.out.println("Product Desc:"+product.getProductDesc());
		}
	}

}
