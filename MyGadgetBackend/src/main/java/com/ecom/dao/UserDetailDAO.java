package com.ecom.dao;

import com.ecom.Entity.UserDetail;

public interface UserDetailDAO 
{
	public boolean RegisterUser(UserDetail users);
	
	public boolean UpdateUser(UserDetail users);
	
	public UserDetail getUser(String CustomerName);
	
	public int LogicCheck(String UserName,String Passwrd);
	
}
