package com.spring.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {

	
	@Id
	@Column(name="categoryid")
	@GeneratedValue
	private int categoryid;
	
	@Column(name="categoryname")
	private String categoryname;


	@OneToMany(cascade=CascadeType.ALL)
	
	private Collection<Product> cname= new ArrayList<Product> ();
	
	@OneToMany(mappedBy="category", cascade = CascadeType.ALL)
	private Collection<Item> ciname= new ArrayList<Item> ();
	
	
	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public Collection<Item> getCiname() {
		return ciname;
	}

	public void setCiname(Collection<Item> ciname) {
		this.ciname = ciname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Collection<Product> getCname() {
		return cname;
	}

	public void setCname(Collection<Product> cname) {
		this.cname = cname;
	}

	
}
