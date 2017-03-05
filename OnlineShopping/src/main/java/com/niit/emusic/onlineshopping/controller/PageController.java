package com.niit.emusic.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.emusic.shoppingbackend.dao.ProductDAO;

@Controller

public class PageController 
{
	@Autowired
	
	private ProductDAO productDAO;

	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Home");
		
		mv.addObject("userClickHome",true);
		
		
		
		return mv;
	}


	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts()
	{
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("products",productDAO.list());
		
		mv.addObject("userClickAllProducts",true);
		
		return mv;
	}
	

	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","About Us");
		
		mv.addObject("userClickAbout",true);
		
		return mv;
	}


	@RequestMapping(value="/contact")
	public ModelAndView contact()
	{
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Contact");
		
		mv.addObject("userClickContact",true);
		
		return mv;
	}
	

}

