package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Address;
import com.entity.User3;
import com.entity.Vehicle;




public class Test2 {

		public static void main(String[] args) {
			//AnnotationConfiguration config=new AnnotationConfiguration();

			// create session factory
					SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(User3.class)
											.buildSessionFactory();
					
			// create session
			Session session = factory.getCurrentSession();
			
			try
			{
				System.out.println("Creating new Person object...");
				User3 u= new User3();
				u.setName("Pritesh");
				
				Vehicle v=new Vehicle();
				v.setVehicleName("Nano");
				
				Vehicle v1=new Vehicle();
				v1.setVehicleName("Jeep");
				v.setUser(u);
				v1.setUser(u);
				
				u.getVehicle().add(v);
				u.getVehicle().add(v1);
								
				// start a transaction
				session.beginTransaction();
				
				// save the student object
				System.out.println("Saving the User...");
				session.save(u);
				session.save(v);
				session.save(v1);
				//session.save(p);
				
				// commit transaction
				session.getTransaction().commit();
				session.close();
				
//***************************************LAZY vs EAGER ****************************************
				/*u=null;
				Session s=factory.openSession();
				u=(User)s.get(User.class, 1);
				s.close();
				System.out.println(u.getList_addr().size());*/
			}
			finally
			{}
			

	}

}
