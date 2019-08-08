/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;
import com.wfdlabs.empmgmt.employeeMgmt.repository.EmployeeRepository;

/**
 * @author HP-PC
 *
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	@Autowired
	EmployeeRepository employeeRepository;

	/**
	 * this methos is used to login employeepage based on employeeId and
	 * employeepassword
	 * 
	 * @param empId
	 * @param empPassword
	 * @return
	 */
	@Override
	public Employee login(Integer empId, String empPassword) {
		return employeeRepository.findByEmployeeIdAndPassword(empId, empPassword);
	}

	/**
	 * this method is used to create employee details
	 * 
	 * @param employee
	 * @return employee details
	 */

	@Override
	public List<Employee> createEmployee(Employee employee) {
		System.out.println("Save employee recrod");
		employeeRepository.save(employee);
		return employeeRepository.findAll();
	}

	/**
	 * This method is used to validate password by emplooyeeId, pancard and
	 * dateofbirth
	 * 
	 * @param employeeId
	 * @param employeePancard
	 * @param employeeDob
	 * @return
	 */

	@Override
	public Employee validatePassword(String employeePancard, Date employeeDob, Integer empId) {
		
		return employeeRepository.findByEmployeeIdAndPancard(empId,employeePancard);
		
	}
}
