package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.Entity.UserDetail;
import com.ecom.dao.UserDetailDAO;

@Controller
public class LoginCheckController {
	
	@Autowired
	UserDetailDAO userdetaildao;
	
	@RequestMapping("/login")
	public String loginpage()
	{
		
		return "Login";
	}
	
	/*post method (userDetails)
	//call dao method and pass username and password
	if(returntype == 200) {
		return "loginscucess";
	} else if(returntype = 401) {
		return "logincfailure";
	}else if(returntype = 404) {
		return "register";
	}*/
	
	@RequestMapping(value="/logincheck" ,method=RequestMethod.POST)
	public String LoginCheck(@RequestParam("Username")String userName,@RequestParam("passwrd")String passwrd)
	{
		int user= userdetaildao.LogicCheck(userName, passwrd);
		System.out.println("UserName :"+userName);
		System.out.println("Password :"+passwrd);
		
		if(user == 200)
		{
			return "LoginSuccess";
		}
		else if(user == 401)
		{
			return "GotoLogin";
		}
		else if(user == 404)
		{
		return "GotoRegister";
	    }
		
		return "HomePage";
		
	}	
		
	

}
