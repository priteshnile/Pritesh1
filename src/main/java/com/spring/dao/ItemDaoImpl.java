package com.spring.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Category;
import com.spring.model.Item;
import com.spring.model.Product;
import com.spring.model.User;

@Repository("itemDao")
public class ItemDaoImpl implements ItemDao{

	private static final Logger logger = LoggerFactory.getLogger(ItemDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void deleteItem(int itemid) {
		System.out.println("Inside delete of ItemDao");
		Session session = this.sessionFactory.getCurrentSession();
		Item p = (Item) session.load(Item.class, new Integer(itemid));
		if(null != p){
			session.delete(p);
		}
	}

	@Override
	public void updateItem(Item i) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(i);
	}

	@Override
	public Item getItemById(int itemid) {
		Session session = this.sessionFactory.getCurrentSession();		
		Item p = (Item) session.load(Item.class, new Integer(itemid));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void addItem(Item i) {
			 System.out.println("Initial imagepath is "+i.getImagepath());
	
		
		 System.out.println("#########"+i.getImagepath());
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("In add Item of ItemDao");
		
		String s=i.getName();
		String s2="";
		char a[]=s.toCharArray();
	
		for(int j=0;j<a.length;j++)
		{
			if(a[j]=='.')
			{
				j=a.length;
			}
			else
			{
				s2=s2+String.valueOf(a[j]);
			}
			
		}
		i.setName(s2);
		session.save(i);
	}

	@Override
	public List<Item> viewitems() {
		System.out.println("list items in dao");
		Session session = this.sessionFactory.getCurrentSession();
		List<Item> l =new ArrayList<Item> ();
		l= session.createQuery("from Item").list();
	//	System.out.println("image path------->"+l.get(0).getImagepath());
		System.out.println("list is "+l);
		for (Item f: l)
		{
			System.out.println(f.getItemid());
		}
		return l;
	}

	@Override
	public List<Category> getCategories() {
		System.out.println("inside getcategories of itemdao");
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> l =new ArrayList<Category> ();
		l= session.createQuery("from Category").list();
		System.out.println("image path------->"+l.get(0).getCategoryname());
		return l;
	}

	@Override
	public List<Product> getProducts() {
		System.out.println("inside getProducts of itemdao");
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> l =new ArrayList<Product> ();
		l= session.createQuery("from Product").list();
		System.out.println("image path------->"+l.get(0).getProductname());
		return l;
	}

	@Override
	public List<Item> getselecteditem() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Item> l =new ArrayList<Item> ();
		l= session.createQuery("from Item where productid=16").list();
		System.out.println("Inside dao getselecteditem of ItemDao");
		System.out.println(l.get(0).getName());
		
		//System.out.println("image path------->"+l.get(0).getProductname());
		return l;
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Item> l =new ArrayList<Item> ();
		l= session.createQuery("from Item").list();
	//	System.out.println("image path------->"+l.get(0).getImagepath());
		
		return l;
	}

	@Override
	public List<Item> getselecteditem(int productid) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Item> l =new ArrayList<Item> ();
		System.out.println("Inside dao getselecteditem of ItemDao");
		Criteria criteria = session.createCriteria(Item.class).createAlias("product", "product")
			    .add(Restrictions.eq("product.productid", productid));
		l=criteria.list();
	
		
		for(Item x : l)
		{
			System.out.println(x.getName());
			String s=x.getName();
			String s2="";
			char a[]=s.toCharArray();
		
			for(int j=0;j<a.length;j++)
			{
				if(a[j]=='.')
				{
					j=a.length;
				}
				else
				{
					s2=s2+String.valueOf(a[j]);
				}
				
			}
			x.setName(s2);
			
	    }
			
		
			
		
		return l;
	}

	@Override
	public int getProductId() {
		// TODO Auto-generated method stub
		
		return 11;
	}

	

	

	
	}


