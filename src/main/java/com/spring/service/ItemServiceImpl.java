package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.ItemDao;
import com.spring.model.Category;
import com.spring.model.Item;
import com.spring.model.Product;



@Service("itemService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDao d;
	
	@Override
	@Transactional
	public List<Item> viewitems() {
		System.out.println("Inside list Items");
		
		return this.d.viewitems();
	}
	
	@Override
	 @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteItem(int itemid) {
		// TODO Auto-generated method stub
		System.out.println("Inside delete of ItemService");
		d.deleteItem(itemid);
	}

	@Override
	@Transactional
	public void updateItem(Item i) {
		// TODO Auto-generated method stub
		d.updateItem(i);
	}

	@Override
	@Transactional
	public Item getItemById(int itemid) {
		// TODO Auto-generated method stub
		Item item=d.getItemById(itemid);
		return 	item;
	}

	@Override
	@Transactional
	public void saveitem(Item item) {
		// TODO Auto-generated method stub
		this.d.addItem(item);
	}

	@Override
	@Transactional
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return this.d.getCategories();
	}

	@Override
	@Transactional
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return this.d.getProducts();
	}

	@Override
	@Transactional
	public List<Item> getselecteditem(int productid) {
		// TODO Auto-generated method stub
		System.out.println("Inside getselecteditem of ItemService ");
		return this.d.getselecteditem(productid);
	}

	@Override
	@Transactional
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return this.d.getAllItems();
	}

	@Override
	@Transactional
	public List<Item> getselecteditem() {
		// TODO Auto-generated method stub
		return this.d.getselecteditem();
	}

	@Override
	@Transactional
	public int getProductId() {
		// TODO Auto-generated method stub
		return this.d.getProductId();
	}

	
	
	

}
