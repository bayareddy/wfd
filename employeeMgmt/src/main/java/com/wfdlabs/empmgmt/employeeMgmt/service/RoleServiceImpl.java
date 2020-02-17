package com.wfdlabs.empmgmt.employeeMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Role;
import com.wfdlabs.empmgmt.employeeMgmt.repository.RoleRepository;
import com.wfdlabs.empmgmt.employeeMgmt.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	/**
	 * This method is used to create role and save details to role
	 * 
	 * @param role
	 * @return
	 */
	@Override
	public Role createRole(Role role) {
		System.out.println("Save role record");
		return roleRepository.save(role);
	}

	/**
	 * This method is used to get role details based on role id
	 * 
	 * @param rollId
	 * @return
	 */
	@Override
	public Role getRole(Integer rollId) {
		return roleRepository.findById(rollId).get();
	}

	/**
	 * This method is used to get all role records
	 */
	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	/**
	 * this method is used to delete particular record based on rollId
	 */
	@Override
	public String deleteRole(Integer rollId) {
		roleRepository.deleteById(rollId);
		return "record1 deleted successfully";

	}

	/**
	 * This method is used to update role record based on role id.
	 * 
	 * @param rollId
	 */
	@Override
	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}
}
