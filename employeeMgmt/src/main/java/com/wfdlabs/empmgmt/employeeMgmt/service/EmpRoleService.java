/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import java.util.List;

import com.wfdlabs.empmgmt.employeeMgmt.entity.EmpRole;

public interface EmpRoleService {
	/**
	 * This method is used to create EmpRole Details
	 * @param pEmpRole
	 * @return
	 */

	EmpRole createEmpRole(EmpRole pEmpRole);
	/**
	 * This is method is used to get  the EmpRole details by using Id
	 * @param empRoleId
	 * @return
	 */

	EmpRole getEmpRole(Integer empRoleId);
	/**
	 * This method is used to update the EmpRole Details
	 * @param pEmpRole
	 * @return
	 */

	EmpRole updateEmpRole(EmpRole pEmpRole);
	/**
	 * This method is used to delete the EmpRole details by using Id
	 * @param empRoleId
	 * @return
	 */

	String deleteEmpRole(Integer empRoleId);
	List<EmpRole> getAllEmpRole();

	

}
