package com.example.RoleBased.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RoleBased.model.EmpProPojo;
import com.example.RoleBased.model.Modules;
import com.example.RoleBased.model.Project;
import com.example.RoleBased.model.User;
import com.example.RoleBased.model.User_Roles;
import com.example.RoleBased.pojo.Role_module_pojo;
import com.example.RoleBased.pojo.UserRolesUpdatePojo;
import com.example.RoleBased.pojo.User_roles_pojo;
import com.example.RoleBased.services.UserServices;

@RestController
@RequestMapping("/pronix")
@CrossOrigin(origins = "*")
@Validated
public class MainController {

	@Autowired
	private UserServices userServices;
	
	@PostMapping("/user_registration")
	public Object user_registration(@RequestBody User userDetails) {
		return userServices.UserRegistration(userDetails);
	}
	@PostMapping("/adding_roles")
	public Object adding_roles(@RequestBody Role_module_pojo user_roles_pojo) {
		System.out.println("tets");
		return userServices.AddingRoles(user_roles_pojo);
	}
	@PostMapping("/addingModule")
	public Object addingModule(@RequestBody Modules modules) {
		return userServices.AddingModules(modules);
	}
	@PostMapping("/assignRoles")
	public Object assigningRoles(@RequestBody User_roles_pojo user_roles_pojo) {
		return userServices.AssigingRoles(user_roles_pojo);
	}
	@GetMapping("/getAllRoles")
	public Object getAllRoles() {
		return userServices.getAllroles();
	}
	@GetMapping("/getAllUserRoles")
	public Object getAllroles() {
		return userServices.UserRoles();
	}
	@GetMapping("/getUsersByRole/{role}")
	public List<User_Roles> getRole(@PathVariable String role){
		return userServices.ListByRoles(role);
	}
	@PutMapping("/updateRoles")
	public Object updateRoles(@RequestBody UserRolesUpdatePojo userRolesUpdatePojo) {
		return userServices.UpdateRoles(userRolesUpdatePojo);
	}
	@GetMapping("/test")
	public Object test(){ return null;}

	@PostMapping("/addproject")
	public Object addproject(@RequestBody Project project) {
		return userServices.addProject(project);
	}
	@PostMapping("/assignEmployeeToProject")
	public Object assignEmployeeToProject(@RequestBody EmpProPojo emppojo) {
		return userServices.assignEmployeeToProject(emppojo);
	}
	@DeleteMapping("/{pId}/{eId}")
	public Object removeEmployee(@PathVariable long pId,@PathVariable long eId) {
		return userServices.removeEmoployeeFromProject(pId, eId);
	}
}
