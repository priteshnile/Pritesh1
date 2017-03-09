package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Item;
import com.spring.model.Person;
import com.spring.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HttpSession s;
	public HttpServletRequest request;
	
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	    
	  
	@Override
	public void addUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("Inserting");
		//String query="insert into user(firstname,lastname,email,usertype ,phone_no, gender ,city, password) values ("+"'"+u.getFirstName()+"','"+u.getLastName()+"','"+u.getEmail()+"','user','"+u.getPhone_no()+"','"+u.getGender()+"','"+u.getCity()+"','"+u.getPassword()+"')";
		//session.createQuery(query);
		session.persist(u);
	}

	@Override
	public void deleteUser(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, new Integer(userId));
		if(null != p){
			session.delete(p);
		}
	}

	@Override
	public void updateUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
	}


	@Override
	public List<User> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> personsList =new ArrayList<User> ();
		personsList= session.createQuery("from user").list();
		for(User p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		User p = (User) session.load(User.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	/*@Override
	public String loginCheck(User user) {
		System.out.println("Inside logincheck of User dao");
		System.out.println(user.getEmail());
		Session session = this.sessionFactory.getCurrentSession();
		List<User> l =new ArrayList<User> ();
		
		String email=user.getEmail();
		l = session.createCriteria(User.class).add(Restrictions.eq( "email", email )).list();
			   // .add(Restrictions.eq("user.email", email));
		//l=criteria.list();
		
		User u=l.get(0);
		System.out.println(u.getPassword());
		String r="";
		if(user.getPassword().equals(u.getPassword()))
		{
			r="adminsuccess";
			//r="http://localhost:8088/SpringMVCHibernate/login/";
			//r="adminsuccess";
			System.out.println("Now go to success page");
			HttpSession s =request.getSession();
			s.setAttribute("id", user);
		}
		else
		{
			r="index";
			System.out.println("Now go to index page");
		}
		System.out.println("Password retrieved from database is "+user.getPassword());
		System.out.println("finally r is "+r);
		return r;



}*/
	
	@Override
	public String loginCheck(User user) {
		System.out.println("Inside logincheck of User dao");
		Session session = this.sessionFactory.getCurrentSession();
		List<User> l =new ArrayList<User> ();
		l= session.createQuery("from User where email= '"+user.getEmail()+"'").list();
		User u=l.get(0);
		System.out.println("Last Name is"+user.getLastName()+"Password is "+u.getPassword()+"usertype is "+u.getUsertype());
		String r=" ";
		
		String usertype=u.getUsertype();
		
		
		
		if(user.getPassword().equals(u.getPassword()))
		{
			r="adminsuccess";
			System.out.println("Now go to success page");
			//HttpSession s =request.getSession();
			//s.setAttribute("id", user);
			user.setFirstName(u.getFirstName());
			if(usertype.equalsIgnoreCase("admin"))
			{
				r="adminsuccess";
			}
			else
			{
				r="display";
			}
		}
		else
		{
			r="index";
			System.out.println("Now go to index page");
		}
		System.out.println("Password retrieved from database is "+user.getPassword());
		System.out.println("finally r is "+r);
		return r;


}


	@Override
	public List<User> viewusers() {
		System.out.println("list users");
		Session session = this.sessionFactory.getCurrentSession();
		List<User> l =new ArrayList<User> ();
		l= session.createQuery("from User").list();
		
		return l;
	}



	@Override
	public List<String> getEmails() {
		System.out.println("Inside getEmails of User dao");
		
		Session session = this.sessionFactory.getCurrentSession();
		List<User> u =new ArrayList<User> ();
		List<String> l =new ArrayList<String> ();
		Criteria c = session.createCriteria(User.class)
			    .setProjection(Projections.projectionList()
			      .add(Projections.property("email"), "email"))
			    .setResultTransformer(Transformers.aliasToBean(User.class));
		//Criteria c = session.createCriteria(User.class)
			  //  .add(Restrictions.eq("email", "email"));
		//Query c = session.createQuery("select u.email from User u");
		u = c.list();
		for(User s:u)
		{
			l.add(s.getEmail());
		}
		return l;
	}



	@Override
	public User getUserfromEmail(String email) {
		System.out.println("Inside getUserfromEmail of User dao");
		Session session = this.sessionFactory.getCurrentSession();
		List<User> l =new ArrayList<User> ();
		l= session.createQuery("from User where email= '"+email+"'").list();
		User u=l.get(0);
		return u;
	}

	
	
}
