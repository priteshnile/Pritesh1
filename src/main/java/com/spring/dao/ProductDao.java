package com.spring.dao;

import java.util.List;

import com.spring.model.Category;
import com.spring.model.Product;

public interface ProductDao {

	public void addProduct(Product p);

	public List<Product> getProducts();

	public List<Category> getCategories();

}
