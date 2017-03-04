package com.niit.emusic.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class PageController 
{
@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting","Welcocme to Learn Spring");
		
		
		return mv;
	}


}

