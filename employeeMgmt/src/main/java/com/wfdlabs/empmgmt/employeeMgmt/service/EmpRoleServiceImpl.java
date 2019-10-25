/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.wfdlabs.empmgmt.employeeMgmt.entity.EmpRole;
import com.wfdlabs.empmgmt.employeeMgmt.repository.EmpRoleRepository;
import com.wfdlabs.empmgmt.employeeMgmt.repository.EmployementHistoryRepository;
@Service
public class EmpRoleServiceImpl implements EmpRoleService {
	@Autowired
	EmpRoleRepository empRoleRepository;
	/**
	 * This method is used to create EmpRole Details
	 * @param pEmpRole
	 * @return
	 */

	@Override
	public EmpRole createEmpRole(@RequestBody EmpRole pEmpRole) {
		return empRoleRepository.save(pEmpRole);
	}
	/**
	 * This method is used to get the EmpRole Details
	 * @param empRoleId
	 * @return
	 */

	@Override
	public EmpRole getEmpRole(@PathVariable Integer empRoleId) {
		return empRoleRepository.findById(empRoleId).get();
	}
	/**
	 * This method is used to update the EmpRole Details
	 * @param pEmpRole
	 * @return
	 */

	@Override
	public EmpRole updateEmpRole(@RequestBody EmpRole pEmpRole) {
		
		return empRoleRepository.save(pEmpRole);
	}
	/**
	 * This method is used to delete the EmpRole Details
	 * @param empRoleId
	 * @return
	 */

	@Override
	public String deleteEmpRole(@PathVariable Integer empRoleId) {
		empRoleRepository.deleteById(empRoleId);
		return empRoleId + " Delete Successfully";
	}
	@Override
	public List<EmpRole> getAllEmpRole() {
	
		return empRoleRepository.findAll();
	} 
	
	
	

	
}


