package com.spring.dao;

import java.util.List;

import com.spring.model.Category;
import com.spring.model.Item;
import com.spring.model.Product;

public interface ItemDao {

	public void deleteItem(int itemid);

	public void updateItem(Item i);

	public Item getItemById(int itemid);

	public void addItem(Item i);

	public List<Item> viewitems();

	public List<Category> getCategories();

	public List<Product> getProducts();

	public List<Item> getselecteditem(int productid);

	public List<Item> getAllItems();

	public List<Item> getselecteditem();

	public int getProductId();

	//public List<Category> getCategories();

	//public void addCategory(Category c);

	

	

}
