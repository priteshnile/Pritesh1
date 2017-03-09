package com.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {

	
	@Id
	@Column(name="categoryid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryid;
	
	
	private String categoryname;

	@OneToMany(mappedBy="category", cascade = CascadeType.ALL)
	private Collection<Item> cname= new ArrayList<Item> ();
	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Collection<Item> getCname() {
		return cname;
	}

	public void setCname(Collection<Item> cname) {
		this.cname = cname;
	}
}
