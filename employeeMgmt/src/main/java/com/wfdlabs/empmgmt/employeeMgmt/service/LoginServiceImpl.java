/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;
import com.wfdlabs.empmgmt.employeeMgmt.repository.EmployeeRepository;


/**
 * @author HP-PC
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
 EmployeeRepository employeeRepository;

	@Override
	public Employee login(Integer empId, String empPassword) {
		return employeeRepository.findByEmployeeIdAndPassword(empId, empPassword);
	}
	
}
