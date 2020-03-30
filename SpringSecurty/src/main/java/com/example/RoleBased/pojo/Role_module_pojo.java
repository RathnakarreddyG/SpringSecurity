package com.example.RoleBased.pojo;

import java.util.List;

import com.example.RoleBased.model.Modules;

public class Role_module_pojo {

	private Long role_id;

	private String role_name;

	private String description;
	
	private List<Modules> modules;

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Modules> getModules() {
		return modules;
	}

	public void setModules(List<Modules> modules) {
		this.modules = modules;
	}
	
	

}
