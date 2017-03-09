package com.spring.service;

import java.util.List;

import com.spring.model.Category;

public interface CategoryService {
	public void savecategory(Category c);

	public List<Category> getCategories();
}
