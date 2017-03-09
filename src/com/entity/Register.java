package com.entity;


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
@Table(name="register")
public class Register {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="Name")
	private String name;
	
	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Role.class)
	@JoinColumn(name="roleId", referencedColumnName="RoleId")
	private Role rollname;
	
	
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
	public Role getRollname() {
		return rollname;
	}
	public void setRollname(Role rollname) {
		this.rollname = rollname;
	}
	
	
}
