package com.wfdlabs.empmgmt.employeeMgmt.service;
import com.wfdlabs.empmgmt.employeeMgmt.entity.Role;
import java.util.List;

public interface RoleService {
	/**
	 * This method is used to create role
	 * 
	 * @param role
	 * @return
	 */
	Role createRole(Role role);

	/**
	 * This method is used to get role details based on role id
	 * 
	 * @param rollId
	 * @return
	 */
	Role getRole(Integer rollId);

	/**
	 * This method is used to get all role details based on role id
	 * 
	 * @return role details
	 */
	public List<Role> getAllRoles();

	/**
	 * This method is used to delete role record based on role id.
	 * 
	 * @param rollId
	 */
	public String deleteRole(Integer rollId);
	public Role updateRole(Role role);

}
