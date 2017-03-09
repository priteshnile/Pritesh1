package com.demo;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Address;
import com.entity.Register;
import com.entity.Role;
import com.entity.User3;
import com.entity.Vehicle;




public class Test {

		public static void main(String[] args) {
			//AnnotationConfiguration config=new AnnotationConfiguration();

			// create session factory
					SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Register.class)
											.buildSessionFactory();
					
			// create session
			Session session = factory.getCurrentSession();
			
			try
			{
				System.out.println("Creating new Person object...");
				
				
				
				Register u1 = new Register();
				u1.setName("Sharad12");
				
				Register u2 = new Register();
				u2.setName("Sharad123");
				
				Register u3 = new Register();
				u3.setName("Sharad1234");
				
				Role r=new Role();
				r.setRoleName("User");
				u1.setRollname(r);
				u2.setRollname(r);
				u3.setRollname(r);
				
				Collection<Register> a = new ArrayList<Register>();
				
				a.add(u1);
				a.add(u2);
				a.add(u3);
				
				r.setRolename(a);
				// start a transaction
				session.beginTransaction();
				
				// save the student object
				System.out.println("Saving the User...");
				
				session.persist(r);
			
				
				//session.save(p);
				
				// commit transaction
				session.getTransaction().commit();
				session.close();
				
			}
			finally
			{}
			
	}

}
