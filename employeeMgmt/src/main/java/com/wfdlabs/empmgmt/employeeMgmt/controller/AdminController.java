package com.wfdlabs.empmgmt.employeeMgmt.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Role;
import com.wfdlabs.empmgmt.employeeMgmt.service.RoleService;
import java.util.List;

@RestController
@RequestMapping("/Role")
public class AdminController {
	@Autowired
	private RoleService roleService;

	/**
	 * This method is used to create role and save role details
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Role createRole(@RequestBody Role role) {
		System.out.println("Role:" + role);
		System.out.println("service scope:" + roleService);
		return roleService.createRole(role);
	}

	/**
	 * This method is used to get role details based on role id
	 * 
	 * @param rollId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Role createRoles(@RequestParam Integer rollId) {
		System.out.println("Role:" + rollId);
		System.out.println("service scope:" + roleService);
		return roleService.getRole(rollId);
	}

	/**
	 * This method is used to get all role details
	 * 
	 * @return all role details
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Role> getRoles() {
		return roleService.getAllRoles();
	}

	/**
	 * This method is used to update particular client details
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Role updateRole(@RequestBody Role role) {
		System.out.println("Role:" + role);
		System.out.println("Service scope:" + roleService);
		return roleService.updateRole(role);

	}

	/**
	 * This method is used to delete particular record based on rollid
	 * 
	 * @param rollId
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteRoles(@RequestParam Integer rollId) {
		System.out.println("Role:" + rollId);
		System.out.println("service scope:" + roleService);
		roleService.deleteRole(rollId);
		return "record deleted sucessfully";
	}
}
