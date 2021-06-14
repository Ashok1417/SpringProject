package com.ecom.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.Entity.Product;

@Transactional
@Repository(value = "productDao")
public class ProductImplementation implements ProductDAO
{
	@Autowired
	SessionFactory session;

	@Override
	public boolean AddProduct(Product product) {
		try {
			session.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean DeleteProduct(Product product) {
		try {
			session.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean UpdateProduct(Product product) {
		try {
			session.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		

	@Override
	public List<Product> getProducts() {
		Session session1 = session.getCurrentSession();
		Query query = session1.createQuery("from Product");
		List<Product> list = query.list();
		return list;
	}

	@Override
	public Product getProduct(int ProductId) {
		Session session1 = session.getCurrentSession();
		Product product = (Product)session1.get(Product.class, ProductId);
		//session.close();
		return product;
	}

	
}
