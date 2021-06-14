package com.ecom.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Mapping Process
@Table  //Mapping Process
public class Supplier
{
	@Id
	int SupplierId;
	String SupplierName;
	String SupplierDesc;
	
	public String getSupplierDesc() {
		return SupplierDesc;
	}

	public void setSupplierDesc(String supplierDesc) {
		SupplierDesc = supplierDesc;
	}

	public int getSupplierID() {
		return SupplierId;
	}
	
	public void setSupplierID(int supplierID) {
		SupplierId = supplierID;
	}
	
	public String getSupplierName() {
		return SupplierName;
	}
	
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	
}
