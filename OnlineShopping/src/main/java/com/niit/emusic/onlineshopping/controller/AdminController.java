package com.niit.emusic.onlineshopping.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.emusic.shoppingbackend.dao.CategoryDAO;
import com.niit.emusic.shoppingbackend.dao.ProductDAO;
import com.niit.emusic.shoppingbackend.model.Category;
import com.niit.emusic.shoppingbackend.model.Product;

@Controller
public class AdminController 
{
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	
	@RequestMapping("/adminAccess")
	public ModelAndView  setUpForm (Map <String, Object> map)
	{
	    ModelAndView mv = new ModelAndView("page");
		Product product=new Product();
		
		mv.addObject("product", product);
		mv.addObject("userClickAdminProduct", true);
		mv.addObject("productList",productDAO.list());
		return mv;
		
	}
	
	@RequestMapping("/adminAccessc")
	public ModelAndView  setUpFormCategory (Map <String, Object> map)
	{
	    ModelAndView mv = new ModelAndView("page");
	Category category=new Category();
		
		mv.addObject("category", category);
		mv.addObject("userClickAdminCategory", true);
		mv.addObject("categoryList",categoryDAO.list());
		return mv;
		
	}
	
	
	@RequestMapping(value="/product.do",method=RequestMethod.POST)
	public ModelAndView doActions(@ModelAttribute @Valid Product product,BindingResult result,@RequestParam String action,Map<String , Object> map)
	{
	
		
		Product productResult=new Product();
		
		
		switch(action.toLowerCase())
		{
		
		
		case "add":
			productDAO.add(product);
			productResult=product;
			break;
			
		case "edit":
			productDAO.update(product);
			productResult=product;
			break;
			
		case "delete":
			productDAO.delete(productDAO.get(product.getId()));
			productResult=product;
			break;
			
		case "search":
			Product searchProduct=productDAO.get(product.getId());
			productResult=searchProduct !=null ? searchProduct :new Product();
			break;
			
			
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("product", productResult);
		mv.addObject("userClickAdminProduct", true);
		mv.addObject("productList",productDAO.list());
		return mv;
	}
	

	
	

	
	@RequestMapping(value="/category.do",method=RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute @Valid Category category,BindingResult result,@RequestParam String action,Map<String , Object> map)
	{
	
		
		Category categoryResult=new Category();
		
		
		switch(action.toLowerCase())
		{
		
		
		case "add":
			categoryDAO.add(category);
			categoryResult=category;
			break;
			
		case "edit":
			categoryDAO.update(category);
			categoryResult=category;
			break;
			
		case "delete":
			categoryDAO.delete(categoryDAO.get(category.getId()));
			categoryResult=category;
			break;
			
		case "search":
			Category searchCategoroy=categoryDAO.get(category.getId());
			categoryResult=searchCategoroy !=null ? searchCategoroy :new Category();
			break;
			
			
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("category", categoryResult);
		mv.addObject("userClickAdminCategory", true);
		mv.addObject("categoryList",categoryDAO.list());
		return mv;
	}
	

}