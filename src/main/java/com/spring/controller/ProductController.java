package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Category;
import com.spring.model.Item;
import com.spring.model.Product;
import com.spring.model.User;
import com.spring.service.ProductService;

@Controller
public class ProductController {
@Autowired
	private ProductService pService;
	
@RequestMapping("/addproduct")  
public ModelAndView showproductform(Model model){  
 System.out.println("Inside addproduct of ProductController");
 List<Category> catList=(List<Category>) this.pService.getCategories();
 model.addAttribute("list", catList);
    return new ModelAndView("product","command",new Product());  
} 

@RequestMapping(value="/saveproduct",method = RequestMethod.POST)  
public String saveproduct(@ModelAttribute("product") Product p, Model model){  
 System.out.println("Inside saveproduct of ProductController");
 List<Category> catList=(List<Category>) this.pService.getCategories();
 for(Category z: catList)
 {
	 if(z.getCategoryid()==(p.getCategory().getCategoryid()))
	 {
		 String cname=z.getCategoryname();
		 System.out.println(cname);
		 p.getCategory().setCategoryname(cname);
	 }
 }
 
 List<Product> lp= new ArrayList<Product> ();
 lp.add(p);
 p.getCategory().setCname(lp);
    pService.saveproduct(p);  
    
    return "adminsuccess";//will redirect to index1 request mapping  
}  

@RequestMapping(value="/showProducts",method = RequestMethod.POST)  
public @ResponseBody List<Product> showproduct(){  
 System.out.println("Inside showproduct of ProductController");

 
List<Product> lp= new ArrayList<Product> ();
 

    lp=pService.getProducts();
    for(Product p:lp)
    {
    	//System.out.println(p.getProductname());
    }
        
    return lp;
}  

@RequestMapping(value="/logintest",method = RequestMethod.POST)  
public @ResponseBody List<String> logintest(@ModelAttribute("user") User user){  
 System.out.println("Inside logintest of ProductController");
System.out.println(user.getEmail());
 List<String> l=new ArrayList<String> ();
//List<Product> lp= new ArrayList<Product> ();
 
/* lp.add(new Product(1,"Mobile"));
 lp.add(new Product(2,"Mobile"));
 lp.add(new Product(3,"Mobile"));*/
 String r="test";
 l.add(r);
 
   /* lp=pService.getProducts();
    for(Product p:lp)
    {
    	System.out.println(p.getProductname());
    }*/
        
    return l;
}  

}
