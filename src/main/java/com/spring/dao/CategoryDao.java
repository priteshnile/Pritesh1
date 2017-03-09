package com.spring.dao;

import java.util.List;

import com.spring.model.Category;

public interface CategoryDao {

	void addCategory(Category c);

	List<Category> getCategories();

}
