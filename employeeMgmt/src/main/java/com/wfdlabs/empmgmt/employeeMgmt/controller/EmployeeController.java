/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;
import com.wfdlabs.empmgmt.employeeMgmt.entity.Leave;
import com.wfdlabs.empmgmt.employeeMgmt.entity.Permision;
import com.wfdlabs.empmgmt.employeeMgmt.service.EmployeeService;

/**
 * @author DELL
 *
 */
@RestController
@RequestMapping("Employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	/**
	 * This class is used to post the Employee details
	 * 
	 * @param Employee
	 * @return
	 */
	
	@RequestMapping(method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee pEmployee) {
		System.out.println("Permision:" + pEmployee);
		return employeeService.createPermision(pEmployee);
	
	}
	@RequestMapping(value="/{employeeId}",method = RequestMethod.GET)
	public Employee getemployee(@RequestParam Integer employeId) {
		System.out.println("Employee:" + employeId);
		return employeeService.getemployee(employeId);
	}
	@RequestMapping(value="/{employeeId}",method = RequestMethod.DELETE)
	public String deleteemployee(@RequestParam Integer employeeId) {
		System.out.println("PermisionTypeId:" + employeeId);
		employeeService.deleteemployee(employeeId);
		return "delete record successfully";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Employee updateemployee(@RequestBody Employee pEmployee) {
		System.out.println("Employee:" + pEmployee);
		return employeeService.updatePermision(pEmployee);

	}
}
