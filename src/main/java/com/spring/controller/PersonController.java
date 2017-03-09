package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Person;
import com.spring.model.User;
import com.spring.service.PersonService;

@Controller
public class PersonController {
	
	private static final String MAPPING="/";
	@Autowired
	private PersonService personService;
	/*
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}*/
	
	/*@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String firstpage() {
		System.out.println("Inside listPersons");
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "index";
	}*/
	

	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String secondpage() {
		System.out.println("show person page");
		
		return "test";
	}
	
	/*@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String showuserform(Model model) {
		System.out.println("show user form");
		model.addAttribute("user", new User());
		
		return "user";
	}*/
	
	/*@RequestMapping(value = "/viewpersons", method = RequestMethod.GET)
	public String viewpersons(Model model) {
		System.out.println("Inside listPersons");
		//model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "viewpersons";
	}*/
	
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listPersons(Model model) {
		System.out.println("Inside listPersons");
		model.addAttribute("person", new Person());
		System.out.println("Everything is fine till here");
		model.addAttribute("listPersons", this.personService.listPersons());
		System.out.println("lETS SEE");
		return "person";
	}*/
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:"+MAPPING;
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:"+MAPPING;
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
	
}
