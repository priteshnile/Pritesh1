package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Item;
import com.spring.model.KartItem;
import com.spring.model.Order;
import com.spring.model.Product;
import com.spring.model.User;
import com.spring.service.ItemService;
import com.spring.service.UserService;

@Controller
public class OrderController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemService itemService;

	@Autowired
	HttpSession s;
	
	 static int i;
	 
	 @RequestMapping(value="/updateKart",method = RequestMethod.GET)  
	    public  String updateKart(@RequestParam("itemid") int itemid,@RequestParam("quantity") int quantity,Model model){  
		 //List<Item> kart=(List<Item>) s.getAttribute("kart");
		 List<KartItem> kart2=(List<KartItem>)s.getAttribute("kart2");
		 System.out.println("Inside updateKart method of OrderController");
		 
      System.out.println("itemid is "+itemid);
    
			 for(KartItem k:kart2)
			 {
			if(k.getItemid()==itemid)
			{
				k.setQuantity(quantity);
			}
			 }
			
			 
			  s.setAttribute("kart2", kart2);
		  model.addAttribute(new KartItem());
				//  model.addAttribute(new Order());
				  return "kart";
				  //return new ModelAndView("kart","command",new Item());
		 }
	 
	 
	 @RequestMapping(value="/removeFromKart",method = RequestMethod.GET)  
	    public ModelAndView removeFromKart(@RequestParam("itemid") int itemid/*,@RequestParam("quantity") int quantity[]*/,Model model){  
		 //List<Item> kart=(List<Item>) s.getAttribute("kart");
		 List<KartItem> kart2=(List<KartItem>)s.getAttribute("kart2");
		 System.out.println("Inside removeFromKart method of OrderController");
		 
         System.out.println("itemid is "+itemid);
        /* for(int i=0;i<quantity.length;i++)
         {
         	System.out.println(quantity[i]);
         	
         }*/
			  System.out.println("Now I am removing ");
               int index=0;
			  for(int i=0;i<kart2.size();i++)
			  {
				 
				  if(kart2.get(i).getItemid()==itemid)
				  {
					  index=i;
				  }
			  }
			  kart2.remove(index);
			  
			  System.out.println("Showing kart");
			  for(KartItem i:kart2)
			  {
				  System.out.println(i.getName());
				  
			  }
			 // s.removeAttribute("kart");
			 // s.removeAttribute("kart2");
			 // s.setAttribute("kart", kart);
			  s.setAttribute("kart2", kart2);
		  model.addAttribute(new KartItem());
		  model.addAttribute("kart2",kart2 );
				//  model.addAttribute(new Order());
				  return new ModelAndView("kart");
				  //return new ModelAndView("kart","command",new Item());
		 }
	 
	 @RequestMapping(value="/placeorder",method = RequestMethod.POST)  
	    public ModelAndView placeorder(ModelMap model){  
		 System.out.println("Inside placeorder method of OrderController");
		 
        List<KartItem> list=(List<KartItem>) s.getAttribute("kart2");
        model.addAttribute("list", list);
		 
	        return new ModelAndView("placedorder");//will redirect to index1 request mapping  
	    }  
	 
	 @RequestMapping(value="/goBackToLogin",method = RequestMethod.POST)  
	    public @ResponseBody String goBackToLogin(@RequestParam("pagename") int pagename, Model model){  
		
		 System.out.println("Inside goBackToLogin method of OrderController");
		 System.out.println(pagename);
		 s.setAttribute("pagename", pagename);
		 return "login";
		 }

	 @RequestMapping(value="/addToKart",method = RequestMethod.POST)  
	    public @ResponseBody String addToKart(@RequestParam("itemid") int itemid,/*@RequestParam("quantity") int quantity,*/ Model model){  
		 //List<Item> kart=(List<Item>) s.getAttribute("kart");
		 List<KartItem> kart2=(List<KartItem>) s.getAttribute("kart2");
		 System.out.println("Inside addToKart method of OrderController");
		User a=(User) s.getAttribute("id");
		System.out.println("Session is valid "+a.getEmail());
		 
		 
			  Item item=itemService.getItemById(itemid);
			
			  KartItem k=new KartItem(item.getItemid(), 1, item.getPrice(), item.getName(), item.getImagepath(), item.getType(), item.getProduct(), item.getCategory());
			  kart2.add(k);
			  s.setAttribute("kart2", kart2);
	
			  for(KartItem i:kart2)
			  {
				 /* KartItem k=new KartItem(i.getItemid(),1, i.getPrice(), i.getName(), i.getImagepath(), i.getType(), i.getProduct(), i.getCategory());
				  */System.out.println("Showing kart "+k.getName());
				  
			  }
			  s.setAttribute("kart2", kart2);
			  
			  int productid=itemService.getProductId();
			  
			  List <Item> l=new ArrayList<Item> ();
			  l=this.itemService.getselecteditem(productid);
		
	//*****************************************Printing AddToKart List*******************************************
		  
			  model.addAttribute("list",l );
		        return "Successfully added into kart.";  
		 }

	 
	 @RequestMapping(value = "/kart", method = RequestMethod.GET)
		public ModelAndView showkart(Model model) {
			System.out.println("Inside showkart of OrderController");
			//List<Item> kart=(List<Item>) s.getAttribute("kart");
			List<KartItem> kart2=(List<KartItem>) s.getAttribute("kart2");
			for(KartItem i:kart2)
			  {
				  System.out.println("Showing kart "+i.getName());
			  }
			
			//  model.addAttribute("kart",kart );
			  model.addAttribute("kart2",kart2 );
			  model.addAttribute(new Item());
			  model.addAttribute(new KartItem());
			//  model.addAttribute(new Order());
			  
			  return new ModelAndView("kart","command",new KartItem()); 
		}
}
