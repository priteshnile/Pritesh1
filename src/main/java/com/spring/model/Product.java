package com.spring.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	 public Product() {
		// TODO Auto-generated constructor stub
	}
	
	 public Product(int id,String name)
	 {
		 this.productid = id;
		 this.productname = name;
	 }
	
	
	@Id
	@Column(name="productid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productid;
	
	@Column(name="productname")
	private String productname;
	
	//@ManyToOne(cascade=CascadeType.ALL, targetEntity=Category.class)
	//@JoinColumn(name="categoryid", referencedColumnName="categoryid")
	//@Column(name="categoryid")
	@ManyToOne(cascade=CascadeType.ALL)
	
	//@JoinColumn(name="categoryid")
	private Category category;
	
	@OneToMany//(mappedBy="product"/*, cascade = CascadeType.ALL*/)
	private Collection<Item> pname= new ArrayList<Item> ();

	public Collection<Item> getPname() {
		return pname;
	}

	public void setPname(Collection<Item> pname) {
		this.pname = pname;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
