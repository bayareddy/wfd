package com.wfdlabs.empmgmt.employeeMgmt.controller;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wfdlabs.empmgmt.employeeMgmt.entity.EmpRole;
import com.wfdlabs.empmgmt.employeeMgmt.service.EmpRoleService;

@RequestMapping("/empRole")
@RestController
public class EmpRoleController {
	
	@Autowired
	EmpRoleService empRoleService;
	
	/**
	 * This method is used to create EmpRole details
	 * 
	 * @param EmpRole
	 * @return
	 */
	
	@RequestMapping(method = RequestMethod.POST)
	public EmpRole createEmpRole(@RequestBody EmpRole pEmpRole) {
		return empRoleService.createEmpRole(pEmpRole);
		
	}
	
	/**
	 * This method is used to get the particular EmpRole based on Id
	 * 
	 * @param Id
	 * @return
	 */
	
	@RequestMapping(value = "/{empRoleId}", method = RequestMethod.GET)
	public ResponseEntity<EmpRole> getEmpRole(@PathVariable Integer empRoleId){
		EmpRole empRole = null;
		Boolean noSuchElement = false;
		try {
			empRole= empRoleService.getEmpRole(empRoleId);
		}catch (NoResultException nsee) {
			noSuchElement = true;
		}
		if(noSuchElement || empRole == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(empRole, HttpStatus.OK);
	}
	
	/**
	 * This method is used to update EmpRole details
	 * 
	 * @param EmpRole
	 * @return
	 */
	
	@RequestMapping(method = RequestMethod.PUT)
	public  EmpRole updateEmpRole(@RequestBody EmpRole pEmpRole) {
		return empRoleService.updateEmpRole(pEmpRole);
		
	}
	
	/**
	 * This method is used to delete the particular EmpRole based on Id
	 * 
	 * @param Id
	 * @return
	 */
	
	@RequestMapping(value = "/{empRoleId}", method = RequestMethod.DELETE)
	public String deleteEmpRole(@PathVariable Integer empRoleId) {
		return empRoleService.deleteEmpRole(empRoleId);
		
	}
	
}


