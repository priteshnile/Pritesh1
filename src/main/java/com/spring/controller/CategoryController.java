package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Category;
import com.spring.model.Item;
import com.spring.service.CategoryService;



@Controller
public class CategoryController {
	@Autowired
	private CategoryService cService;

	
	 @RequestMapping("/addcategory")  
	    public ModelAndView showcategoryform(Model model){  
		 System.out.println("Inside addcategory of categoryController");
	        return new ModelAndView("category","command",new Category());  
	    } 
	 
	 @RequestMapping(value="/savecategory",method = RequestMethod.POST)  
	    public String savecategory(@ModelAttribute("category") Category c, Model model){  
		 System.out.println("Inside savecategory of CategoryController");
	        cService.savecategory(c);  
	       // model.addAttribute("list", this.cService.getCategories());
	        System.out.println("everything is fine till here");
	       // model.addAttribute("item", new Item());
	        return "adminsuccess";//will redirect to index1 request mapping  
	    }  
}
