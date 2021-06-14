package com.ecom.SampTest;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ecom.Entity.Product;
import com.ecom.dao.ProductDAO;



public class ProductDAOTest 
{
	static ProductDAO productdao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecom");
		context.refresh();
		
		productdao=(ProductDAO)context.getBean("productDao");
	}
	
	@Test
	@Ignore
	public void addProductTest()
	{
		Product product1 = new Product();
		product1.setProductId(1002);
		product1.setProductName("Amul");
		product1.setProductDesc("Best Cool Drink Available");
		product1.setProductReview("Tasty Drink");
		
		assertTrue("While Problem Occur In Add Product" , productdao.AddProduct(product1));
	}
	
	@Test
	@Ignore
	public void updateProductTest()
	{
		Product product1 = productdao.getProduct(1001);
		product1.setProductName("Standard");
		product1.setProductDesc("All Type Of Crackers Available");
		product1.setProductReview("Good FireWork Product");
		
		assertTrue("While Problem Occur in Update Product", productdao.UpdateProduct(product1));
	}
	
	@Test
	@Ignore
	public void DeleteProductTest()
	{
		Product product1 = productdao.getProduct(1002);
		
		assertTrue("While Problem Occur in Delete Product", productdao.DeleteProduct(product1));
	}
	
	@Test
	
	public void getProductTest()
	{
		List<Product> listproduct = productdao.getProducts();
		
		assertTrue("While Problem Occur in Show Product", listproduct.size()>0);
		for(Product product:listproduct)
		{
			System.out.println("Product ID :" +product.getProductId());
			System.out.println("Product Name :"+product.getProductName());
			System.out.println("Product Desc :"+product.getProductDesc());
			System.out.println("Product Review :"+product.getProductReview());
		}
		
	}
	
}
