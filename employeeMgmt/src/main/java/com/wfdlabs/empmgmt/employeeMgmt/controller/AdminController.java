 package com.wfdlabs.empmgmt.employeeMgmt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Role;
import com.wfdlabs.empmgmt.employeeMgmt.service.RoleService;
import java.util.List;
import java.util.NoSuchElementException;

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
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Role> createRole(@RequestBody Role role) {
		System.out.println("Role:" + role);
		System.out.println("service scope:" + roleService);
		role= roleService.createRole(role);
		return new ResponseEntity<>(role,HttpStatus.CREATED);
	}

	/**
	 * This method is used to get role details based on role id
	 * 
	 * @param rollId
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Role> createRoles(@RequestParam Integer rollId) {
		System.out.println("Role:" + rollId);
		System.out.println("service scope:" + roleService);
		Role role=null;
		boolean noElementFlag=false;
		try {
		 role= roleService.getRole(rollId);
	}
		catch(NoSuchElementException nsee) {
			noElementFlag=true;
		}
		if(noElementFlag||role==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Role>(role,HttpStatus.OK);
	}

	/**
	 * This method is used to get all role details
	 * 
	 * @return all role details
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Role>> getRoles() {
		List<Role> roleList= roleService.getAllRoles();
		return new ResponseEntity<>(roleList,HttpStatus.OK);
	}

	/**
	 * This method is used to update particular client details
	 * 
	 * @param role
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Role> updateRole(@RequestBody Role role) {
		System.out.println("Role:" + role);
		System.out.println("Service scope:" + roleService);
		role= roleService.updateRole(role);
		return new ResponseEntity<>(role,HttpStatus.OK);

	}

	/**
	 * This method is used to delete particular record based on rollid
	 * 
	 * @param rollId
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity deleteRoles(@RequestParam Integer rollId) {
		System.out.println("Role:" + rollId);
		System.out.println("service scope:" + roleService);
		roleService.deleteRole(rollId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
