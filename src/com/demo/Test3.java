package com.demo;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Address;
import com.entity.Category;
import com.entity.Item;
import com.entity.Register;
import com.entity.Role;
import com.entity.User3;
import com.entity.Vehicle;




public class Test3 {

		public static void main(String[] args) {
			//AnnotationConfiguration config=new AnnotationConfiguration();

			// create session factory
					SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Item.class)
											.buildSessionFactory();
					
			// create session
			Session session = factory.getCurrentSession();
			
			try
			{
				System.out.println("Creating new Person object...");
				
				
				Item i1= new Item();
				i1.setName("item111");
				i1.setPrice(140);	
				i1.setImagepath("item1image");
				
				Item i2= new Item();
				i2.setName("item12");
				i2.setPrice(15000);	
				i2.setImagepath("item2image");
				
				Item i3= new Item();
				i3.setName("item13");
				i3.setPrice(16000);	
				i3.setImagepath("item3image");
				
				Category c= new Category();
				c.setCategoryname("Category2");
				i1.setCategory(c);
				i2.setCategory(c);
				i3.setCategory(c);
				
			
				
				Collection<Item> a = new ArrayList<Item>();
				
				a.add(i1);
				a.add(i2);
				a.add(i3);
				
				c.setCname(a);
				//r.setRolename(a);
				// start a transaction
				session.beginTransaction();
				
				// save the student object
				System.out.println("Saving the User...");
				
				session.persist(i1);
			
				
				//session.save(p);
				
				// commit transaction
				session.getTransaction().commit();
				session.close();
				
			}
			finally
			{}
			
	}

}
