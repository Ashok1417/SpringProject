package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.Entity.Category;
import com.ecom.dao.CategoryDAO;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryDAO categorydao;
	
	@RequestMapping("/category")
	public String getCategory(Model m)
	{
		List<Category> list=categorydao.getCategories();
		m.addAttribute("categoryList", list);
		return "Category";
	}
	
	@RequestMapping(value="/insertcategory" , method=RequestMethod.POST)
	public String insertCategory(@RequestParam("CategoryId")String categoryId,@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc,Model m)
	{
		System.out.println("Category Id :"+categoryId);
		System.out.println("Category Name :"+categoryName);
		System.out.println("Category Desc :"+categoryDesc);
		
		Category category = new Category();
		category.setCategoryId(categoryId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categorydao.addCategory(category);
		
		List<Category> list=categorydao.getCategories();
		m.addAttribute("categoryList", list);
		
		return "Category";
	}
	
	@RequestMapping("/deletecategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")String categoryId,Model m)
	{
		Category category = categorydao.getCategory(categoryId);
		categorydao.deleteCategory(category);
		
		List<Category> list=categorydao.getCategories();
		m.addAttribute("categoryList", list);
		
		return "Category";
	}
	@RequestMapping("/editcategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")String categoryId,Model m)
	{
		Category category = categorydao.getCategory(categoryId);
		m.addAttribute("Category", category);
		return "UpdateCategory";
	}
	
	@RequestMapping(value="/updatecategory" , method=RequestMethod.POST)
	public String updateCategory(@RequestParam("CategoryId")String categoryId,@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc,Model m)
	{
		System.out.println("Category Id :"+categoryId);
		System.out.println("Category Name :"+categoryName);
		System.out.println("Category Desc :"+categoryDesc);
		
		Category category = categorydao.getCategory(categoryId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categorydao.updateCategory(category);
		
		List<Category> list=categorydao.getCategories();
		m.addAttribute("categoryList", list);
		
		return "Category";
	}
}
