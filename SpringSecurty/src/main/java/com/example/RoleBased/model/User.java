package com.example.RoleBased.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	private String first_name;
	
	private String last_name;
	
	private String email;
	
	private String password;
	
//	@JoinTable(
//			name = "user_roles",joinColumns = @JoinColumn(name="user_id" ,referencedColumnName = "user_id" ),
//			inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "role_id")
//			)
//	@OneToMany
//	private List<Roles> roles;
	
	public User() {
		
	}
	
	

	public User(Long user_id, String first_name, String last_name, String email, String password) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		
	}



	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	
}
