package com.example.RoleBased.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.RoleBased.model.User_Roles;


public interface UserRolesDAO extends JpaRepository<User_Roles, Long> {
	
	 @Query(value="select * from user_roles where user_id=?1",nativeQuery = true)
	    User_Roles findByUserId(Long user_id);

	 @Query(value="select * from user_roles where role_id=?1",nativeQuery = true)
	    List<User_Roles> findByRoleId(Long role_id);
	    
	    @Transactional
	    @Modifying
	    @Query(value = "update user_roles set role_id=?2 where user_role_id=?1",nativeQuery = true)
	    void updateRoles(Long user_role_id,Long role_id);
}
