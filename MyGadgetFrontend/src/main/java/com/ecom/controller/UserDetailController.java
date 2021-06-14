package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.Entity.UserDetail;
import com.ecom.dao.UserDetailDAO;

@Controller
public class UserDetailController {
	
	@Autowired
	UserDetailDAO userdetaildao;
	
	@RequestMapping("/signup")
	public String signuppage() {
		
		return "UserDetail";
	}
	
	@RequestMapping(value="/insertuser" , method=RequestMethod.POST)
	public String addUser(@RequestParam("Username")String userName,@RequestParam("passwrd")String passwrd,@RequestParam("CustomerName")String customerName,
			@RequestParam("Role")String role,@RequestParam("Address")String address,@RequestParam("MobileNo")String mobileNo,@RequestParam("EmailId")String emailId,
			@RequestParam("enabled")boolean enabled)
	{
		
		UserDetail userdetail = new UserDetail();
		userdetail.setUserName(userName);
		userdetail.setPasswrd(passwrd);
		userdetail.setCustomerName(customerName);
		userdetail.setRole(role);
		userdetail.setAddress(address);
		userdetail.setMobileNo(mobileNo);
		userdetail.setEmailId(emailId);
		userdetail.setEnabled(enabled);
		
		userdetaildao.RegisterUser(userdetail);
		
		System.out.println("Record Inserted");
		
		return "UserDetail";
	}

}
