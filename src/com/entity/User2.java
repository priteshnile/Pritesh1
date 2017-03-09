package com.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;



@Entity
@Table(name="user")
public class User2 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
    @ElementCollection
    @JoinTable(name="USER_ADDRESS",
                 joinColumns=@JoinColumn(name="User_Id")
    		)
    @GenericGenerator(name = "hilo-gen", strategy = "hilo")
    @CollectionId(columns={@Column(name="ADDRESS_ID")} , generator= "hilo-gen", type= @Type(type = "long"))
	private Collection<Address> list_addr =new ArrayList<Address> ();
	private String phone_no;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public Collection<Address> getList_addr() {
		return list_addr;
	}
	public void setList_addr(Collection<Address> list_addr) {
		this.list_addr = list_addr;
	}
	
	
}
