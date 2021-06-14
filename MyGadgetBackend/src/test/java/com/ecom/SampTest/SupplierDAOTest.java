package com.ecom.SampTest;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.core.annotation.Order;

import com.ecom.Entity.Supplier;
import com.ecom.dao.SupplierDAO;


@FixMethodOrder(MethodSorters.DEFAULT)
public class SupplierDAOTest 
{
	static SupplierDAO supplierdao;
	
	
	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecom");
		context.refresh();
		
		supplierdao=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	@Test
	@Ignore
	public void addSupplierTest()
	{
		Supplier supplier1 = new Supplier();
		supplier1.setSupplierID(1003);
		supplier1.setSupplierName("Akash");
		supplier1.setSupplierDesc("Smart Dealing");
		assertTrue("Problem Occured While Adding Supplier :" , supplierdao.addSupplier(supplier1));
	}
	
	@Test
	@Ignore
	public void updateSupplierTest()
	{
		Supplier supplier1 = supplierdao.getSupplier(1001);
		supplier1.setSupplierName("Arun");
		supplier1.setSupplierDesc("Good Dealing");
		
		assertTrue("problem Occured while updating Supplier " , supplierdao.updateSupplier(supplier1));
		
	}
	
	@Test
	@Ignore
	public void deleteSupplierTest()
	{
		Supplier supplier1 = supplierdao.getSupplier(1003);
		
		assertTrue("Problem Occured While Delete Supplier :" , supplierdao.deleteSupplier(supplier1));
	}
	@Test
	public void TestGetCategory()
	{
		List<Supplier> listcategory = supplierdao.getSuppliers();
		
		assertTrue("Problem Occured While Delete Supplier :" , listcategory.size()>0);
		
		for(Supplier supplier : listcategory) {
			System.out.println("Supplier Name : "+supplier.getSupplierName());
			System.out.println("Supplier Desc : "+supplier.getSupplierDesc());
		}
	}
	
}
