package com.example.RoleBased.model;

import java.util.ArrayList;
import java.util.List;

public class EmpProPojo {
	
	private Long project_id;
	
	private List<User> empList;
	
	private List emp = new ArrayList<>();

	public EmpProPojo() {
		super();
	}

	public EmpProPojo(Long project_id, List<User> empList) {
		super();
		this.project_id = project_id;
		this.empList = empList;
	}

	public Long getProject_id() {
		return project_id;
	}

	public void setProject_id(Long project_id) {
		this.project_id = project_id;
	}

	public List<User> getEmpList() {
		return empList;
	}

	public void setEmpList(List<User> empList) {
		this.empList = empList;
	}

	public List getEmp() {
		return emp;
	}

	public void setEmp(List emp) {
		this.emp = emp;
	}

	
	
}
