package com.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class WebPageController 

{
			
		@RequestMapping("/homepage")
		public String homePage()
		{
			//System.out.println("Home Page Created");
			return "HomePage";
		}

}


