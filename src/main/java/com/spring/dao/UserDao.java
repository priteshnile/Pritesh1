package com.spring.dao;

import java.util.List;

import com.spring.model.Item;
import com.spring.model.User;

public interface UserDao {

	public void addUser(User u);
	
	public void deleteUser(int userId);
	
	public void updateUser(User u);
	
	 public List<User> getAllUsers();
	 
	 public User getUserById(int id);

	public String loginCheck(User user);

	public List<User> viewusers();

	public List<String> getEmails();

	public User getUserfromEmail(String email);

	//public List<Item> getselecteditems();
}
