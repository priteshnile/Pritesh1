package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.PersonDAO;
import com.spring.dao.UserDao;
import com.spring.model.Item;
import com.spring.model.Person;
import com.spring.model.User;


@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService{
	
	public HttpServletRequest request;
	
	@Autowired
	private UserDao d;

	@Override
	 @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String loginCheck(User user) {
		System.out.println("Inside loginCheck of UserService Impl");
		String r=d.loginCheck(user);
		System.out.println("r in service "+r);
		
		
		return r;
	}

	@Override
	 @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUser(User u) {
		System.out.println("Inside Add user of UserService");
		// TODO Auto-generated method stub
		this.d.addUser(u);
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		this.d.deleteUser(userId);
	}

	@Override
	@Transactional
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		this.d.updateUser(u);
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
	return this.d.getAllUsers();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return this.d.getUserById(id);
	}

	@Override
	@Transactional
	public List<User> viewusers() {
		System.out.println("Inside viewusers of UserService");
		return this.d.viewusers();
	}


	@Override
	public void logout() {
		HttpSession s=request.getSession();  
		  s.removeAttribute("id");
	}

	@Override
	@Transactional
	public List<String> getEmails() {
		// TODO Auto-generated method stub
		return this.d.getEmails();
	}

	@Override
	@Transactional
	public User getUserfromEmail(String email) {
		// TODO Auto-generated method stub
		return this.d.getUserfromEmail(email);
	}

}
