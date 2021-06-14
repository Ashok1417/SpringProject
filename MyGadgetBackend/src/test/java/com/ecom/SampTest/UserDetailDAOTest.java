package com.ecom.SampTest;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.Entity.UserDetail;
import com.ecom.dao.UserDetailDAO;

public class UserDetailDAOTest 

{
	static UserDetailDAO Userdao;

	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecom");
		context.refresh();
		
		Userdao = (UserDetailDAO) context.getBean("UserDAO");
		
	}	
	
	@Test
	public void RegisterUserTest()
	{
		UserDetail user1 = new UserDetail();
		user1.setUserName("Srini");
		user1.setPasswrd("123456");
		user1.setCustomerName("Srinivasan");
		user1.setRole("Manager");
		user1.setAddress("79/171 nethaji nager");
		user1.setMobileNo("984023251");
		user1.setEmailId("Srinivasan@gmail.com");
		user1.setEnabled(true);
		
		assertTrue("Problem Occured While Adding UserDeatil :" , Userdao.RegisterUser(user1));
	}

}
