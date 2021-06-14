package com.ecom.SampTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBConnectionTest 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext Cont = new AnnotationConfigApplicationContext();
		
		Cont.scan("com.ecom");
		Cont.refresh();
		
	}
}
