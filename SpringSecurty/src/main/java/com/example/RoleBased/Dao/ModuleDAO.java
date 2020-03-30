package com.example.RoleBased.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RoleBased.model.Modules;

public interface ModuleDAO extends JpaRepository<Modules, Long> {

}
