package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CategoryDao;
import com.spring.dao.ItemDao;
import com.spring.model.Category;

@Service("cService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CategoryServiceImpl implements CategoryService{

	
	@Autowired
	private CategoryDao d;
	@Override
	@Transactional
	public void savecategory(Category c) {
		// TODO Auto-generated method stub
		System.out.println("in savecatgry of itemservice");
		this.d.addCategory(c);
	}
	@Override
	@Transactional
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return this.d.getCategories();
	}

	
	
}
