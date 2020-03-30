package com.example.RoleBased.Dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.RoleBased.model.project_employees;

public interface Project_employeeDAO extends JpaRepository<project_employees, Long> {
	
	@Transactional
	@Modifying
	@Query(value = "delete from project_employees where project_id=?1 and emp_id=?2",nativeQuery = true)
	void RemoveEmployeeFromProject(Long project_id,Long emp_id);

}
