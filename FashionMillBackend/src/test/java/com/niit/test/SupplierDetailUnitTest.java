package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDetailDAO;
import com.niit.model.Category;
import com.niit.model.SupplierDetail;
import com.niit.model.UserDetail;



public class SupplierDetailUnitTest{
	
	static SupplierDetailDAO supplierDAO;
	
	
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplierDAO = (SupplierDetailDAO) context.getBean("supplierDAO");
	}
	@Ignore
	@Test
	public void registersupplierTest()
	{
		SupplierDetail supplier=new SupplierDetail();
		
		supplier.setSupplierId(125);
		supplier.setSupplierName("Stark Collection");
		supplier.setSupplierAddr("Mumbai");
		assertTrue("Problem in Adding Supplier:",supplierDAO.addSupplier(supplier));
		
	}
	


	@Ignore
	@Test
	public void getSupplierTestCase() {
		SupplierDetail supplier = supplierDAO.getSupplier(9);
		assertNotNull("Supplier could not be retrived",supplier);
	}
	
	@Ignore
	@Test
	public void updateSupplierTestCase() {
		SupplierDetail supplier = supplierDAO.getSupplier(9);
		
		supplier.setSupplierName("Croma");
		
		assertTrue("Supplier could not be updated",supplierDAO.updateSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void deleteSupplierTestCase() {
		SupplierDetail supplier = supplierDAO.getSupplier(1);
		assertTrue("Supplier could not be deleted",supplierDAO.deleteSupplier(supplier));
	}
	//@Ignore
	@Test
	public void listSupplierTestCase() {
		
		List<SupplierDetail> listSuppliers = supplierDAO.listSuppliers();
		System.out.println(listSuppliers.size());
		assertNotNull("List could not be created",listSuppliers.size()>0);
		
		for(SupplierDetail supplier:listSuppliers)
		{
			System.out.println("Supplier Id:"+supplier.getSupplierId());
			System.out.println("Supplier Name:"+supplier.getSupplierName());
			System.out.println("Supplier Addess:"+supplier.getSupplierAddr());
		}
	}
}


