package com.example.RoleBased.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RoleBased.model.Project;

public interface ProjectDAO extends JpaRepository<Project, Long> {

}
