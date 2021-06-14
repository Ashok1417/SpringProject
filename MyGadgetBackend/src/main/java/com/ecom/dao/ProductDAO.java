package com.ecom.dao;

import java.util.List;

import com.ecom.Entity.Product;

public interface ProductDAO 
{
	public boolean AddProduct(Product product);
	public boolean DeleteProduct(Product product);
	public boolean UpdateProduct(Product product);
	public List<Product> getProducts();
	public Product getProduct(int ProductId);
}
