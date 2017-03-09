package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Item;
import com.spring.model.KartItem;
import com.spring.model.Person;
import com.spring.model.Product;
import com.spring.model.Status;
import com.spring.model.User;
import com.spring.service.ItemService;
import com.spring.service.PersonService;
import com.spring.service.UserService;

@Controller
public class UserController {
	private static final String MAPPING="/";
	
	@Autowired
	private UserService userService;
	@Autowired
	private ItemService pageService;
	
	@Autowired
	HttpSession s;
	
/*	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String showuserform(Model model) {
		System.out.println("show user form");
		model.addAttribute("user", new User());
		
		return "user";
	}*/
	
	
	@RequestMapping(value = "/viewusers", method = RequestMethod.GET)
	public String viewusers(Model model) {
		System.out.println("Inside list Users");
		
		model.addAttribute("list", this.userService.viewusers());
		return "viewusers";
	}
	@RequestMapping(value="/checkemail",method = RequestMethod.POST)  
	public @ResponseBody String checkemail(@RequestParam("email") String email){  
	 System.out.println("Inside checkemail of UserController");
System.out.println(email);
	 
	List<String> l= new ArrayList<String> ();
	 l=userService.getEmails();
	 
	 String s=" ";
	 
	 for(int i=0; i<l.size();i++)
	 {
		 if(l.get(i).equalsIgnoreCase(email))
		 {
			 s="y";
			break;
		 }
		 else
		 {
			 s="n";
		 }
	 }
System.out.println("Last value of s is "+s);
	    /*lp=userService.getProducts();
	    for(Product p:lp)
	    {
	    	System.out.println(p.getProductname());
	    }*/
	        
	    return s;
	} 
	
	
	@RequestMapping(value="/checkemail2",method = RequestMethod.POST)  
	public /*@ResponseBody*/ String checkemail2(@RequestParam("email") String email,ModelMap model){  
	 System.out.println("Inside checkemail2 of UserController");
	 User p=new User();
	 String return2="";
System.out.println(email+"#");
	 
	List<String> l= new ArrayList<String> ();
	 l=userService.getEmails();
	 
	 String s1=" ";
	 
	 for(int i=0; i<l.size();i++)
	 {
		 if(l.get(i).equals(email))
		 {			
			 s1="y";
			 break;
		 }
		 else
		 {
			 s1="n";	
		 }
	 }
	 System.out.println("value of s1 is "+s1);
	 if(s1.equalsIgnoreCase("y"))
	 {
		 p.setEmail(email);
		System.out.println("After fetching object from database email is "+p.getEmail());    
	 }
	 else
	 {
		 p.setEmail(email);
		 this.userService.addUser(p); 
		 return2="display";
	 }
	 
System.out.println("Last value of s is "+s1);
model.addAttribute("userNAME", p.getEmail());
	s.setAttribute("id", p);
	System.out.println(p.getEmail());
	User a=(User) s.getAttribute("id");
	System.out.println(a.getEmail());
	List<KartItem> kart2=new ArrayList<KartItem> ();
	s.setAttribute("kart2", kart2);
	    return return2;
	} 
	

	
	 @RequestMapping(value="/authenticate",method = RequestMethod.POST)  
	    public ModelAndView authenticate(@ModelAttribute("user") User user,ModelMap model){  
		 System.out.println("Inside authenticate method of UserController");
	         System.out.println(user.getEmail()+"retrived from browser");
	      
		  	 
		  	String r=" ";
	  	 // if(pagename==0)
		  	if(s.getAttribute("pagename")==null)
		  		
	  	  {   
	  		   r=userService.loginCheck(user);
		        
		      /*  if(!r.equalsIgnoreCase("index"))
		        {*/
		        	model.addAttribute("userNAME", user.getFirstName());
		        	s.setAttribute("id", user);
		        	//List<Item> kart=new ArrayList<Item> ();
					//s.setAttribute("kart", kart);
					List<KartItem> kart2=new ArrayList<KartItem> ();
					s.setAttribute("kart2", kart2);
		        /*	r="adminsuccess";
		        }
		        else
			  	  {
			  		  r="login";
			  	  }
		       */
	  	  }
	  	 else
	  	  {
	  		int pagename=(Integer) s.getAttribute("pagename");
	  		 r=userService.loginCheck(user);
	  		model.addAttribute("userNAME", user.getEmail());
        	s.setAttribute("id", user);
        	List<KartItem> kart2=new ArrayList<KartItem> ();
			s.setAttribute("kart2", kart2);
	  		model.addAttribute("list", this.pageService.getselecteditem(pagename));
			
	  		// r="display";
	  	  }
	       
	        return new ModelAndView(r);//will redirect to index1 request mapping  
	    }  

	 @RequestMapping(value="/adminsuccess",method = RequestMethod.GET)  
	    public ModelAndView success(){  
		
	       
	        return new ModelAndView("adminsuccess");
	    }  
	
	/*@RequestMapping("/login")  
    public ModelAndView login(){  
	  System.out.println("Inside login method of UserDaoImpl");
	  String success=" ";
	  String pagename=(String) s.getAttribute("pagename");
	  System.out.println(pagename);
	  if(pagename.equalsIgnoreCase(null))
	  {
		  success="adminsuccess";
	  }
	  else
	  {
		  success=pagename;
	  }
        return new ModelAndView(success,"command",new User());  
    }*/
	 @RequestMapping("/login")  
	    public ModelAndView login(){  
		  System.out.println("Inside login method of UserDaoImpl");

	        return new ModelAndView("login2","command",new User());  
	    }
	@RequestMapping("/logout")  
    public ModelAndView logout(){  
	  System.out.println("Inside logout method of UserController");
	 // s=request.getSession();  
	  s.removeAttribute("id");
	  s.removeAttribute("pagename");
	  s.removeAttribute("kart");
	  s.invalidate();
        return new ModelAndView("login2","command",new User());  
    }
	
	
	 @RequestMapping("/user")  
	    public ModelAndView showuserform(){  
		 System.out.println("Show user form");
	        return new ModelAndView("user","command",new User());  
	    }  
	
	
	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User p){
		
		System.out.println("Inside addUser");

			//new person, add it
			this.userService.addUser(p);
		
		
		return "redirect:/user?success=true";
		
	}
}
