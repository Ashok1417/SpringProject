package com.ecom.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.Entity.Supplier;
import com.ecom.dao.SupplierDAO;

@Controller
public class SupplierController 
{
	
	
	@Autowired
	SupplierDAO supplierdao;
	
	@RequestMapping("/supplier")
	public String ShowSupplierDetails(Model m)
	{
		List<Supplier> supplierlist = supplierdao.getSuppliers();
		m.addAttribute("supplierlist", supplierlist);
		return "Supplier";
		
	}
	
	@RequestMapping(value="/insertSupplier",method=RequestMethod.POST)
	public String AddSupplier(@RequestParam("SupplierID")int SupplierID,@RequestParam("SupplierName")String SupplierName,@RequestParam("SupplierDesc")String SupplierDesc,Model m)
	{
		System.out.println("Supplier ID:"+SupplierID);
		System.out.println("Supplier Name:"+SupplierName);
		System.out.println("Supplier Desc : "+SupplierDesc);
		
		Supplier supplier1 = new Supplier();
		supplier1.setSupplierID(SupplierID);
		supplier1.setSupplierName(SupplierName);
		supplier1.setSupplierDesc(SupplierDesc);
		
		supplierdao.addSupplier(supplier1);
		
		List<Supplier> supplierlist = supplierdao.getSuppliers();
		m.addAttribute("SupplierList", supplierlist);
		return "Supplier";
	}
	
	@RequestMapping("/deletesupplier/{supplierID}")
	public String deleteSupplier(@PathVariable("supplierID")int SupplierID,Model m) 
	{
		Supplier supplier = supplierdao.getSupplier(SupplierID);
		supplierdao.deleteSupplier(supplier);
		
		List<Supplier> supplierlist = supplierdao.getSuppliers();
		m.addAttribute("SupplierList", supplierlist);
		
		return "Supplier";
	}
	
	@RequestMapping("/editsupplier/{supplierID}")
	public String editSupplier(@PathVariable("supplierID")int SupplierID,Model m) 
	{
		Supplier supplier = supplierdao.getSupplier(SupplierID);
		m.addAttribute("Supplier", supplier);
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/updateSupplier",method=RequestMethod.POST)
	public String updateSupplier(@RequestParam("SupplierID")int SupplierID,@RequestParam("SupplierName")String SupplierName,@RequestParam("SupplierDesc")String SupplierDesc,Model m)
	{
		System.out.println("Supplier ID:"+SupplierID);
		System.out.println("Supplier Name:"+SupplierName);
		System.out.println("Supplier Desc : "+SupplierDesc);
		
		Supplier supplier1 = supplierdao.getSupplier(SupplierID);
		supplier1.setSupplierName(SupplierName);	
		supplier1.setSupplierDesc(SupplierDesc);
		
		supplierdao.updateSupplier(supplier1);
		
		List<Supplier> supplierlist = supplierdao.getSuppliers();
		m.addAttribute("SupplierList", supplierlist);
		
		return "Supplier";
	}
}
