package com.example.RoleBased.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project_employees")
public class project_employees {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long project_employee_id;

	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private Project project;

	@ManyToOne()
	@JoinColumn(name = "emp_id", referencedColumnName = "user_id")
	private User employee_list;

	private boolean enable;

	public project_employees() {
		super();
	}

	public project_employees(Long project_employee_id, Project project, User employee_list, boolean enable) {
		super();
		this.project_employee_id = project_employee_id;
		this.project = project;
		this.employee_list = employee_list;
		this.enable = enable;
	}
	

	public project_employees(Project project, User employee_list, boolean enable) {
		super();
		this.project = project;
		this.employee_list = employee_list;
		this.enable = enable;
	}

	public Long getProject_employee_id() {
		return project_employee_id;
	}

	public void setProject_employee_id(Long project_employee_id) {
		this.project_employee_id = project_employee_id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getEmployee_list() {
		return employee_list;
	}

	public void setEmployee_list(User employee_list) {
		this.employee_list = employee_list;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	

}
