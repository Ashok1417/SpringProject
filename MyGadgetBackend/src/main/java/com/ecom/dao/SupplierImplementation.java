package com.ecom.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.Entity.Supplier;

@Transactional
@Repository(value = "supplierDAO")
public class SupplierImplementation implements SupplierDAO
{
	@Autowired
	SessionFactory sessionfactory;
	
	
	@Override
	public boolean addSupplier(Supplier supplier) {
		try {
			sessionfactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateSupplier(Supplier supplier) 
	{
		try 
		{
			sessionfactory.getCurrentSession().update(supplier);	
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteSupplier(Supplier supplier)
	{
		try 
		{
			sessionfactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Supplier> getSuppliers() 
	{
		Session session =  sessionfactory.openSession();
		Query query = session.createQuery("from Supplier");
		List<Supplier> list = query.list();
		session.close();
		return list;
	}

	@Override
	public Supplier getSupplier(int supplierID) 
	{
		Session session = sessionfactory.openSession();
		Supplier supplier = (Supplier)session.get(Supplier.class, supplierID);
		session.close();
		return supplier;
	}
	
}
