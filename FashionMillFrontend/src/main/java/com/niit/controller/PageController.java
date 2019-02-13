package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Product;
import com.niit.model.UserDetail;
import com.niit.dao.ProductDAO;
import com.niit.dao.UserDetailDAO;



@Controller
public class PageController 
{

	@Autowired
    ProductDAO productDAO;
	@RequestMapping("/login")
	public String showLogin(Model m)
	{
	   m.addAttribute("pageinfo", "Login");
	   return "Login";
	}
	
	
	@RequestMapping("/adminhome")
	public String showHome(Model m)
	{
	    m.addAttribute("pageinfo" , "Home");
	    List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		return "AdminHome";
	}
	@RequestMapping("/register")
	public String showRegister(Model m) 
	
	{   m.addAttribute("user", new UserDetail());
		m.addAttribute("pageinfo", "Register");
		
		return "Register";
	}
	
	@RequestMapping("/aboutUs")
	public String showAboutUs(Model m) 
	{ 
		m.addAttribute("pageinfo", "AboutUs");
		
		return "AboutUs";
	}
	
	@RequestMapping("/contactUs")
	public String showContactUs(Model m) 
	{
		 m.addAttribute("pageinfo", "ContactUs");
		
		return "ContactUs";
	}
	
	
	@RequestMapping("/")
	public String showHeader(Model m)
	{
		m.addAttribute("pageinfo","Header");
		return "Header";
	}
	
}
