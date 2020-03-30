package com.example.RoleBased.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.RoleBased.model.User;

public interface UserDetailsDAO extends JpaRepository<User, Long> {
	
	@Query(value = "select * from user_details where email = ?1",nativeQuery = true)
	Optional<User> findbyEmail(String email);

}
