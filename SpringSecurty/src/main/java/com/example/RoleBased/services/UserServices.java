package com.example.RoleBased.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.RoleBased.Dao.ModuleDAO;
import com.example.RoleBased.Dao.ProjectDAO;
import com.example.RoleBased.Dao.Project_employeeDAO;
import com.example.RoleBased.Dao.RoleModuleDAO;
import com.example.RoleBased.Dao.RolesDAO;
import com.example.RoleBased.Dao.UserDatilaEntity;
import com.example.RoleBased.Dao.UserDetailsDAO;
import com.example.RoleBased.Dao.UserRolesDAO;
import com.example.RoleBased.model.EmpProPojo;
import com.example.RoleBased.model.Modules;
import com.example.RoleBased.model.Project;
import com.example.RoleBased.model.Role_Modules;
import com.example.RoleBased.model.Roles;
import com.example.RoleBased.model.User;
import com.example.RoleBased.model.User_Roles;
import com.example.RoleBased.model.project_employees;
import com.example.RoleBased.pojo.Role_module_pojo;
import com.example.RoleBased.pojo.StatusRes;
import com.example.RoleBased.pojo.UserRolesUpdatePojo;
import com.example.RoleBased.pojo.User_roles_pojo;

@Service
public class UserServices {

	@Autowired
	private UserDetailsDAO userDetailsDAO;

	@Autowired
	private RolesDAO rolesDAO;

	@Autowired
	private UserRolesDAO userRolesDAO;

	@Autowired
	private ModuleDAO moduleDAO;

	@Autowired
	private RoleModuleDAO roleModuleDAO;

	@Autowired
	private UserDatilaEntity userDatilaEntity;

	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private Project_employeeDAO project_employeeDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Object UserRegistration(User userDetails) {
		User user = new User();
		user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
		user.setEmail(userDetails.getEmail());
		return userDetailsDAO.save(user);
	}

	public List<StatusRes> AddingRoles(Role_module_pojo role_module_pojo) {
		List<StatusRes> status = new ArrayList<StatusRes>();
		if (role_module_pojo.getRole_name() != null && role_module_pojo.getDescription() != null) {
			Roles roles = new Roles(role_module_pojo.getRole_id(), role_module_pojo.getRole_name(),
					role_module_pojo.getDescription());
			rolesDAO.save(roles);
			for (Modules modules : role_module_pojo.getModules()) {
				if (modules.getModule_id() != null) {
					Optional<Modules> modules_info = moduleDAO.findById(modules.getModule_id());
					Roles roles_details = rolesDAO.findByRoleName(roles.getRole_name());
					Role_Modules rolemodule = new Role_Modules(roles_details, modules_info.get());
					roleModuleDAO.save(rolemodule);
					status.add((new StatusRes("Success", "000", "Role created and role mapped with modules")));
				} else {
					status.add((new StatusRes("Failed", "007", "Modules details not mentioned")));
				}
			}
		} else {
			status.add((new StatusRes("Failed", "007", "Role details not found")));
		}
		return status;
	}

	public Object AddingModules(Modules modules) {
		return moduleDAO.save(modules);
	}

	public Object AssigingRoles(User_roles_pojo user_roles_pojo) {
		List<StatusRes> status = new ArrayList<StatusRes>();
		Optional<User> userDetails = userDetailsDAO.findById(user_roles_pojo.getUser_id());
		Optional<Roles> roles = rolesDAO.findById(user_roles_pojo.getRole_id());
		User_Roles user_Roles1 = userRolesDAO.findByUserId(user_roles_pojo.getUser_id());
		if (user_Roles1 != null) {
			System.out.println("Role already assigned");
			status.add(new StatusRes("Failed", "007", "User already having role"));
		} else {
			User_Roles user_Roles = new User_Roles(userDetails.get(), roles.get());
			userRolesDAO.save(user_Roles);
			status.add(new StatusRes("Success", "000", "" + userDetails.get().getFirst_name() + " Is assgined with "
					+ roles.get().getRole_name() + " Role"));
		}
		return status;
	}

	public Object UserRoles() {
		return userRolesDAO.findAll();
	}

	public Object getAllroles() {
		return rolesDAO.findAll();
	}

	public List<User_Roles> ListByRoles(String role) {
		Roles roles = rolesDAO.findByRoleName(role);
		if (roles == null) {

		}
		List<User_Roles> user_Roles = userRolesDAO.findByRoleId(roles.getRole_id());

		return user_Roles;
	}

	public List<StatusRes> UpdateRoles(UserRolesUpdatePojo userRolesUpdatePojo) {
		List<StatusRes> status = new ArrayList<StatusRes>();
		Optional<User_Roles> user_Roles = userRolesDAO.findById(userRolesUpdatePojo.getUser_role_id());
		if (user_Roles != null) {
			userRolesDAO.updateRoles(userRolesUpdatePojo.getUser_role_id(), userRolesUpdatePojo.getRole_id());
			status.add((new StatusRes("Success", "000", "Role Updated Successfully")));
		} else {
			status.add((new StatusRes("Failed", "007", "User Role id not found")));
		}
		return status;
	}

	public List<User> getall(int page, int size) {

		Pageable pageable = PageRequest.of(page, size);
		Page<User> pageresult = userDatilaEntity.findAll(pageable);
		if (pageresult.hasContent()) {
			return pageresult.getContent();
		} else {
			return new ArrayList<User>();
		}
	}

	public Object addProject(Project project) {
		return projectDAO.save(project);
	}

	public Object assignEmployeeToProject(EmpProPojo emppojo) {

		Project project = projectDAO.findById(emppojo.getProject_id())
				.orElseThrow(() -> new RuntimeException("project not found"));

		for (User details : emppojo.getEmpList()) {
			User tempdetails = userDetailsDAO.findById(details.getUser_id())
					.orElseThrow(() -> new RuntimeException("Employee not found"));
			project_employees ep = new project_employees(project, tempdetails, true);
			project_employeeDAO.save(ep);
		}

		return new StatusRes("Success", "000", "Employee assigned successfully");
	}
	public Object removeEmoployeeFromProject(Long project_id,Long emp_id) {
	
		project_employeeDAO.RemoveEmployeeFromProject(project_id, emp_id);
		
		return new StatusRes("Success","000","Removed Sucessfully");
	}

}
