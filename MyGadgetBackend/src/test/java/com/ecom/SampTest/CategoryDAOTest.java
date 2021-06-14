package com.ecom.SampTest;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.Entity.Category;
import com.ecom.dao.CategoryDAO;

public class CategoryDAOTest
{
	static CategoryDAO categorydao;
	
	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecom");
		context.refresh();
		
		categorydao=(CategoryDAO)context.getBean("CategoryDao");
	}
	
	@Test
	@Ignore
	public void addCategoryTest() 
	{
		Category category1 = new Category();
		category1.setCategoryId("1002");
		category1.setCategoryName("Samsung");
		category1.setCategoryDesc("New Model A series A50s");
		assertTrue("Problem Occur While Adding Category", categorydao.addCategory(category1));
	}
	
	@Test
	@Ignore
	public void UpdateCategoryTest() {
		
		Category category1 = categorydao.getCategory("1001");
		category1.setCategoryName("Xiomi");
		category1.setCategoryDesc("Xiomi Release Brand New Smart Phone 11pro");
		
		assertTrue("Problem Occur While Updating Category" , categorydao.updateCategory(category1));
	}
	
	@Test
	@Ignore
	public void deleteCategoryTest() {
		
		Category category1 = categorydao.getCategory("1002");
		
		assertTrue("Problem Occur While Deleting Category" , categorydao.deleteCategory(category1));
	}
	
	@Test
	public void TestgetCategory() {
		
		List<Category> listcategory1 = categorydao.getCategories();
		
		assertTrue("Problem Ocur While Get Category" , listcategory1.size()>0);
		
		for(Category category : listcategory1) {
		System.out.println("Category Name : " + category.getCategoryName());
		System.out.println("Category Desc : " + category.getCategoryDesc());
		
		}
	}
}
