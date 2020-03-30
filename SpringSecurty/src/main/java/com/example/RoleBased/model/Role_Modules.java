package com.example.RoleBased.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role_module")
public class Role_Modules {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long role_module_id;
	
	@ManyToOne
	@JoinColumn(name = "role_id",referencedColumnName = "role_id")
	private Roles roles;
	
	@ManyToOne
	@JoinColumn(name = "module_id",referencedColumnName = "module_id")
	private Modules modules;
	
	public Role_Modules() {
	}

	public Role_Modules(Long role_module_id, Roles roles, Modules modules) {
		super();
		this.role_module_id = role_module_id;
		this.roles = roles;
		this.modules = modules;
	}
	

	public Role_Modules(Roles roles, Modules modules) {
		super();
		this.roles = roles;
		this.modules = modules;
	}

	public Long getRole_module_id() {
		return role_module_id;
	}

	public void setRole_module_id(Long role_module_id) {
		this.role_module_id = role_module_id;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Modules getModules() {
		return modules;
	}

	public void setModules(Modules modules) {
		this.modules = modules;
	}
	

}
