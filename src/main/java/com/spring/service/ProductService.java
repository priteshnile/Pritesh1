package com.spring.service;

import java.util.List;

import com.spring.model.Category;
import com.spring.model.Product;

public interface ProductService {

	public void saveproduct(Product p);

	public List<Product> getProducts();

	public List<Category> getCategories();

}
