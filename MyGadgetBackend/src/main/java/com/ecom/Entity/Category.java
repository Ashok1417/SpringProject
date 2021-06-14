package com.ecom.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Category {
	
	@Id
	String CategoryId;
	String CategoryName;
	String CategoryDesc;
	
	public String getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(String categoryId) {
		CategoryId = categoryId;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getCategoryDesc() {
		return CategoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		CategoryDesc = categoryDesc;
	}

}
