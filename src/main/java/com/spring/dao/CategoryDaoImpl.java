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

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao{
	private static final Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCategory(Category c) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("Inserting");
		session.persist(c);
	}
	@Override
	public List<Category> getCategories() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> l =new ArrayList<Category> ();
		l= session.createQuery("from Category").list();
		return l;
	}
}
