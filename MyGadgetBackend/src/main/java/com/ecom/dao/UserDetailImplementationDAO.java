package com.ecom.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.Entity.UserDetail;

@Transactional
@Repository(value = "UserDAO")
public class UserDetailImplementationDAO implements UserDetailDAO
{
	
	@Autowired
	SessionFactory Session;

	@Override
	public boolean RegisterUser(UserDetail users) 
	{
		try {
			Session.getCurrentSession().save(users);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean UpdateUser(UserDetail users) 
	{
		try 
		{
			Session.getCurrentSession().update(users);
			return true;
		}
		catch(Exception e) 
		{
		return false;
	    }
}

	@Override
	public UserDetail getUser(String CustomerName) 
	{
		Session session1 = Session.openSession();
		UserDetail user = (UserDetail)session1.get(UserDetail.class , CustomerName );
		Session.close();
		return user;
	}
	
	
	@Override
	public int LogicCheck(String UserName, String Passwrd) {
		
		Session session = Session.openSession();
		UserDetail user = (UserDetail)session.get(UserDetail.class, UserName);
		if(user != null) {
			if(user.getPasswrd().equals(Passwrd)) {
				return 200;
			}
			else
			{
				return 401;
			}
		}
		else
		{	
		return 404;
		}
	}
	

}
