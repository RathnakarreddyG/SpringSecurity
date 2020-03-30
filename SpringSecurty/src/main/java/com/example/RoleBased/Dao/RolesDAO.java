package com.example.RoleBased.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.RoleBased.model.Roles;

public interface RolesDAO extends JpaRepository<Roles, Long> {

	 @Query(value="select * from roles where role_name=?1",nativeQuery = true)
	    Roles findByRoleName(String role);
}
