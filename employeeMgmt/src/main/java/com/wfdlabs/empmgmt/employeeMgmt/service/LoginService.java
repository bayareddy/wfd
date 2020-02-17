/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import java.util.List;
import java.util.Date;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;

/**
 * @author HP-PC
 *
 */
public interface LoginService {

	/**
	 * this methos is used to login employeepage based on employeeId and
	 * employeepassword
	 * 
	 * @param empId
	 * @param empPassword
	 * @return
	 */

	public Employee login(Integer empId, String empPassword);

	/**
	 * this method is used to create employee details
	 * 
	 * @param employee
	 * @return employee details
	 */

	public List<Employee> createEmployee(Employee employee);

	/**
	 * This method is used to validate password by employeeId, pancard and
	 * dateofbirth
	 * 
	 * @param employeeId
	 * @param employeePancard
	 * @param employeeDob
	 * @return
	 */

	public Employee validatePassword(String employeePancard, Date employeeDob, Integer empId);

}
