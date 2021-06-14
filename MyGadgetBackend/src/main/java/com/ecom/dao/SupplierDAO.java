package com.ecom.dao;

import java.util.List;

import com.ecom.Entity.Supplier;

public interface SupplierDAO 
{
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public List<Supplier> getSuppliers();
	public Supplier getSupplier(int supplierID);
}
