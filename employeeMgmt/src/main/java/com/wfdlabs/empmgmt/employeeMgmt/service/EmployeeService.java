package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;

public interface EmployeeService {
	/**
	 * This method used to create Employee details
	 * 
	 * @param pEmployee
	 * @return
	 */

	Employee createEmployee(Employee pEmployee);

	/**
	 * This method is used to get the Employee Details
	 * 
	 * @param employeeId
	 * @return
	 */

	Employee getEmployee(Integer employeeId);

	/**
	 * This method is used to update the Employee Details
	 * 
	 * @param pEmployee
	 * @return
	 */

	Employee updateEmployee(Employee pEmployee);

	/**
	 * This method is used to delete the Employee Details
	 * 
	 * @param employeeId
	 * @return
	 */

	String deleteEmployee(Integer employeeId);

	// Employee generatePdf(Integer employeeId);

}
