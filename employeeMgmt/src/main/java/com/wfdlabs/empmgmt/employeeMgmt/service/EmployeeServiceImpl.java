/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;
import com.wfdlabs.empmgmt.employeeMgmt.repository.EmployeeRepository;

/**
 * @author DELL
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeerepositiory;

	/**
	 * This method is used to create Employee Details
	 * 
	 */
	@Override
	public Employee createEmployee(Employee pEmployee) {
		return employeerepositiory.save(pEmployee);
	}

	/**
	 * This is method is used to get the Employee Details
	 * 
	 */
	@Override
	public Employee getEmployee(Integer employeeId) {
		return employeerepositiory.findById(employeeId).get();
	}

	/**
	 * This method is used to update the Employee Details
	 */
	@Override
	public Employee updateEmployee(Employee pEmployee) {
		return employeerepositiory.save(pEmployee);
	}

	/**
	 * This method is used to delete the Employee Details
	 * 
	 */
	@Override
	public String deleteEmployee(Integer employeeId) {
		employeerepositiory.deleteById(employeeId);
		return employeeId + " Delete Successfully";
	}

}
