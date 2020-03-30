package com.example.RoleBased;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.RoleBased.Dao.UserDetailsDAO;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses  = UserDetailsDAO.class)
public class RoleBasedApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoleBasedApplication.class, args);
	}

}
