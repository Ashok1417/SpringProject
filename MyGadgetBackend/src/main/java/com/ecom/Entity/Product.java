package com.ecom.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product 
{
	
	@Id
	int ProductId;
	String ProductName;
	String ProductDesc;
	String ProductReview;
	
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductDesc() {
		return ProductDesc;
	}
	public void setProductDesc(String productDesc) {
		ProductDesc = productDesc;
	}
	public String getProductReview() {
		return ProductReview;
	}
	public void setProductReview(String productReview) {
		ProductReview = productReview;
	}
	/*@Override
	public String toString() {
		return "Product [ProductId=" + productid + ", ProductName=" + ProductName + ", ProductDesc=" + ProductDesc
				+ ", ProductReview=" + ProductReview + "]";
	}*/
	
	
}
