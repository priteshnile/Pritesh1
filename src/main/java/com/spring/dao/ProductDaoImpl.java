package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Category;
import com.spring.model.Product;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao{
	private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("Inserting");
		session.save(p);
	}

	@Override
	public List<Product> getProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> l =new ArrayList<Product> ();
		l= session.createQuery("from Product").list();
		List <Product> lp=new ArrayList<Product> ();
		for(Product p: l)
		{
			lp.add(new Product(p.getProductid(),p.getProductname()));
			
		}
		return lp;
	}

	@Override
	public List<Category> getCategories() {
		System.out.println("inside getcategories of productmdao");
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> l =new ArrayList<Category> ();
		l= session.createQuery("from Category").list();
		System.out.println("Category Name is------->"+l.get(0).getCategoryname());
		return l;
	}

}
