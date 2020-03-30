package com.example.RoleBased.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RoleBased.model.Role_Modules;

public interface RoleModuleDAO extends JpaRepository<Role_Modules, Long> {

}
