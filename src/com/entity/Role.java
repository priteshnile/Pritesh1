package com.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	@Id
	@Column(name="RoleId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;

@Column(name="rolename")
	private String roleName;
	
@OneToMany(mappedBy="rollname", cascade = CascadeType.ALL)
	private Collection<Register> rolename= new ArrayList<Register> ();
	
public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	//@Column(name="RollName")
	//private String rolename;
	public Collection<Register> getRolename() {
		return rolename;
	}
	public void setRolename(Collection<Register> rolename) {
		this.rolename = rolename;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	 
}
