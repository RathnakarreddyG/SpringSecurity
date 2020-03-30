package com.example.RoleBased.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "modules")
public class Modules {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long module_id;
	
	private String module_name;
	
	private String module_description;
	
	public Modules() {
		
	}
	
	

	public Modules(Long module_id, String module_name, String module_description) {
		super();
		this.module_id = module_id;
		this.module_name = module_name;
		this.module_description = module_description;
	}



	public Long getModule_id() {
		return module_id;
	}

	public void setModule_id(Long module_id) {
		this.module_id = module_id;
	}

	public String getModule_name() {
		return module_name;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	public String getModule_description() {
		return module_description;
	}

	public void setModule_description(String module_description) {
		this.module_description = module_description;
	}
	
	
	
}
