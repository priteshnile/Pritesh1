package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.User;
import com.spring.model.User2;
import com.spring.service.ItemService;


@Controller
public class PageController {
	private List<User2> userList=new ArrayList<User2> ();
	
	
	@Autowired
	private ItemService pageService;
	
	@Autowired
	HttpSession s;
	
	@RequestMapping(value="/AddUser.htm",method=RequestMethod.POST)
	public @ResponseBody String addUser2(@ModelAttribute(value="user") User2 user, BindingResult result ){
		System.out.println("In addUser2 now adding user");
		String returnText;
		if(!result.hasErrors()){
			userList.add(user);
			returnText = "User has been added to the list. Total number of users are " + userList.size();
		}else{
			returnText = "Sorry, an error has occur. User has not been added to list.";
		}
		return returnText;
	}

	@RequestMapping(value="/ShowUsers.htm")
	public String showUsers(ModelMap model){
		//User u1=new User();
		//u1.setName("Pritesh");
		//u1.setEducation("BTech");
		//userList.add(u1);
		model.addAttribute("Users", userList);
		return "ShowUsers";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String firstpage(Model model) {
		//model.addAttribute("isloggedin", "Login");
		System.out.println("show first page");
		//model.addAttribute("list", this.pageService.getProducts());
		//return "AddUser";
		s.removeAttribute("pagename");
		return "index";
	}
	
	@RequestMapping(value = "/{productid}", method = RequestMethod.GET)
	public ModelAndView viewselecteditem(Model model, @PathVariable int productid) {
		System.out.println("Inside viewselecteditem of PageController");
		//System.out.println("productid is "+productid);
		/* User user=(User) s.getAttribute("id");
		System.out.println("%%%%"+user.getFirstName());*/
		
		model.addAttribute("list", this.pageService.getselecteditem(productid));
		//System.out.println("Everything is fine till here");
		  return new ModelAndView("display");  
	}
	
	
	
	@RequestMapping(value = "/mobile", method = RequestMethod.GET)
	public String viewselecteditem(Model model) {
		System.out.println("Inside viewselecteditem of PageController");
		
		model.addAttribute("list", this.pageService.getselecteditem());
		  return "display";  
	}
	
	@RequestMapping(value = "/testmobile", method = RequestMethod.GET)
	public ModelAndView testmobile(Model model) {
		System.out.println("Inside test mobile of PageController");
		
		//model.addAttribute("list", this.pageService.getselecteditem());
		  return new ModelAndView("testmobile");  
	}
	
}
