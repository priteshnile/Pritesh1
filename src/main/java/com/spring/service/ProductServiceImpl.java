package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ProductDao;
import com.spring.model.Category;
import com.spring.model.Product;
@Service("pService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao pd;
	
	@Override
	@Transactional
	public void saveproduct(Product p) {
		// TODO Auto-generated method stub
		System.out.println("in saveproduct of productservice");
		this.pd.addProduct(p);
	}

	@Override
	@Transactional
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return this.pd.getProducts();
	}

	@Override
	@Transactional
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return this.pd.getCategories();
	}

}
