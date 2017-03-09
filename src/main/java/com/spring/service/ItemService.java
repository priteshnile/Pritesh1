package com.spring.service;

import java.util.List;

import org.springframework.ui.Model;

import com.spring.model.Category;
import com.spring.model.Item;
import com.spring.model.Product;

public interface ItemService {

	public void deleteItem(int itemid);
	
	public void updateItem(Item i);
	public Item getItemById(int itemid);



	public List<Item> viewitems();

	public void saveitem(Item item);

	public Object getCategories();

	public List<Product> getProducts();

	public List<Item> getselecteditem(int productid);
	public List<Item> getselecteditem();

	public List<Item> getAllItems();

	public int getProductId();

	
}
