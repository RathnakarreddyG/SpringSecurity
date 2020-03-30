package com.example.RoleBased.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class User_Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_role_id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user_details;

	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private Roles roles;

	public User_Roles() {

	}

	public User_Roles(Long user_role_id, User user_details, Roles roles) {
		super();
		this.user_role_id = user_role_id;
		this.user_details = user_details;
		this.roles = roles;
	}

	public User_Roles(User user_details, Roles roles) {
		super();
		this.user_details = user_details;
		this.roles = roles;
	}

	public Long getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(Long user_role_id) {
		this.user_role_id = user_role_id;
	}

	public User getUser_details() {
		return user_details;
	}

	public void setUser_details(User user_details) {
		this.user_details = user_details;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

}
