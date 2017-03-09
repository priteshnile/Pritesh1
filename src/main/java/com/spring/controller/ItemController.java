package com.spring.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.model.Category;
import com.spring.model.Item;
import com.spring.model.Product;
import com.spring.service.ItemService;



@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	
	
	
	 @RequestMapping("/item")  
	    public ModelAndView showitemform(Model model){  
		 System.out.println("Show item form");
		 model.addAttribute(new Item());
		 List<Product> pList=(List<Product>) this.itemService.getProducts();
		 List<Category> catList=(List<Category>) this.itemService.getCategories();
		    model.addAttribute("list", catList);
			model.addAttribute("plist", pList);
			
	        return new ModelAndView("item");  
	    }  
	 
	 @RequestMapping(value="/saveitem",method = RequestMethod.POST)  
	    public ModelAndView saveitem(@ModelAttribute("item") Item item,BindingResult result,Model model){  
		 System.out.println("Inside saveitem of ItemController");
		 String path="images/";
		 String f= path+item.getName();
		 System.out.println("Final path is "+f);
		 item.setImagepath(f);
		 System.out.println("imagepath is "+item.getImagepath());
		 System.out.println(item.getCategory().getCategoryid());
		 List<Category> catList=(List<Category>) this.itemService.getCategories();
		 for(Category z: catList)
		 {
			 if(z.getCategoryid()==(item.getCategory().getCategoryid()))
			 {
				 String cname=z.getCategoryname();
				 System.out.println(cname);
				 item.getCategory().setCategoryname(cname);
			 }
		 }
		 System.out.println("Category Name is "+item.getCategory().getCategoryname());
		 System.out.println(item.getProduct().getProductid());
		 System.out.println("I am here "+item.getProduct().getCategory());
		 item.getProduct().setCategory(item.getCategory());
		 //item.getProduct().getCategory().setCategoryid(item.getCategory().getCategoryid());
		 List<Product> pList=(List<Product>) this.itemService.getProducts();
		 for(Product p: pList)
		 {
			 if(p.getProductid()==(item.getProduct().getProductid()))
			 {
				 String pname=p.getProductname();
				 System.out.println(pname);
				 item.getProduct().setProductname(pname);;
			 }
		 }
		 System.out.println("Product Name is "+item.getProduct().getProductname());
		
	        itemService.saveitem(item);  
	        return new ModelAndView("redirect:/viewitems");//will redirect to index1 request mapping  
	    } 
	 
	 @RequestMapping(value="/edititemsave",method = RequestMethod.POST)  
	    public ModelAndView editsaveitem(@ModelAttribute("item") Item item, Model model){  
	    	System.out.println("Inside editsaveitem method of ItemController");
	    	 List<Category> catList=(List<Category>) this.itemService.getCategories();
			 for(Category z: catList)
			 {
				 if(z.getCategoryid()==(item.getCategory().getCategoryid()))
				 {
					 String cname=z.getCategoryname();
					 System.out.println(cname);
					 item.getCategory().setCategoryname(cname);
				 }
			 }
			 item.getProduct().setCategory(item.getCategory());
			 //item.getProduct().getCategory().setCategoryid(item.getCategory().getCategoryid());
			 List<Product> pList=(List<Product>) this.itemService.getProducts();
			 for(Product p: pList)
			 {
				 if(p.getProductid()==(item.getProduct().getProductid()))
				 {
					 String pname=p.getProductname();
					 System.out.println(pname);
					 item.getProduct().setProductname(pname);;
				 }
			 }
	    	
	        itemService.updateItem(item);  
	      
	       
	        return new ModelAndView("redirect:/viewitems");  
	    } 
	 
	 @RequestMapping(value="/edititem/{itemid}") 
	    public ModelAndView edititem(@PathVariable int itemid, Model model){  
	    	System.out.println("Inside edit method of ItemController");
	    	
	    	List<Product> pList=(List<Product>) this.itemService.getProducts();
			 List<Category> catList=(List<Category>) this.itemService.getCategories();
			    model.addAttribute("list", catList);
				model.addAttribute("plist", pList);
	        return new ModelAndView("itemeditform","command",itemService.getItemById(itemid));  
	    }  
	 

	 
	@RequestMapping(value = "/viewitems", method = RequestMethod.GET)
	public String viewitem(Model model) {
		System.out.println("Inside controller Items");
		
		model.addAttribute("list", this.itemService.viewitems());
		return "viewitems";
	}
	
	@RequestMapping("/deleteitem/{itemid}")
    public String deleteItem(@PathVariable("itemid") int itemid,Model model){
		System.out.println("inside delete of itemdao");
        this.itemService.deleteItem(itemid);
        model.addAttribute("list", this.itemService.viewitems());
        System.out.println("in itemcontroller now going to viewitems");
        return "viewitems";
    }
	
	/*@RequestMapping("/deleteitem/{itemid}")
    public String deleteItem( @ModelAttribute("item") final Item item,
            final BindingResult mapping1BindingResult,
            final Model model, 
            final RedirectAttributes redirectAttributes){
		
		 redirectAttributes.addFlashAttribute("list", this.itemService.viewitems());

		    return "redirect:viewitems";
    }*/
}