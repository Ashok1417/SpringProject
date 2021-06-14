package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.Entity.Product;
import com.ecom.dao.ProductDAO;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO productdao;
	
	@RequestMapping("/product")
	public String showProductDetails(Model m)
	{
		List<Product> ProductList = productdao.getProducts();
		m.addAttribute("ProductList", ProductList);
		return "Product";
	}
	
	@RequestMapping(value="/insertproduct" ,method=RequestMethod.POST)
	public String insertProduct(@RequestParam("ProductID")int productid,@RequestParam("ProductName")String productname,@RequestParam("ProductDesc")String productdesc,@RequestParam("ProductReview")String productreview,Model m)
	{
		System.out.println("Product ID :"+productid);
		System.out.println("Product Name :"+productname);
		System.out.println("Product Desc :"+productdesc);
		System.out.println("Product Review : "+productreview);
		
		Product product1 = new Product();
		product1.setProductId(productid);
		product1.setProductName(productname);
		product1.setProductDesc(productdesc);
		product1.setProductReview(productreview);
		
		List<Product> ProductList = productdao.getProducts();
		m.addAttribute("ProductList", ProductList);
		
		productdao.AddProduct(product1);
		return "Product";
	}
	@RequestMapping(value="/deleteproduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product = productdao.getProduct(productId);
		productdao.DeleteProduct(product);
		
		List<Product> ProductList = productdao.getProducts();
		m.addAttribute("ProductList", ProductList);
		
		return "Product";
	}
	
	@RequestMapping(value="/editproduct/{productId}")
	public String editProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product = productdao.getProduct(productId);
		m.addAttribute("Product", product);
		return "UpdateProduct";
	}
	@RequestMapping(value="/updateproduct" ,method=RequestMethod.POST)
	public String updateProduct(@RequestParam("ProductID")int productid,@RequestParam("ProductName")String productname,@RequestParam("ProductDesc")String productdesc,@RequestParam("ProductReview")String productreview,Model m)
	{
		System.out.println("Product ID :"+productid);
		System.out.println("Product Name :"+productname);
		System.out.println("Product Desc :"+productdesc);
		System.out.println("Product Review : "+productreview);
		
		Product product = productdao.getProduct(productid);
		product.setProductName(productname);
		product.setProductDesc(productdesc);
		product.setProductReview(productreview);
		
		productdao.UpdateProduct(product);
		
		List<Product> ProductList = productdao.getProducts();
		m.addAttribute("ProductList", ProductList);
		
		return "Product";
	}	
}
