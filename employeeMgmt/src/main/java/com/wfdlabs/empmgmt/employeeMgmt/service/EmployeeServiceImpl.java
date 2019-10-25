/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;
import com.wfdlabs.empmgmt.employeeMgmt.repository.EmployeeRepository;

/**
 * @author DELL
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeerepositiory;

	@Override
	public Employee createPermision(Employee pEmployee) {
			return employeerepositiory.save(pEmployee);
	}

	@Override
	public Employee getemployee(Integer employeId) {
		return employeerepositiory.findById(employeId).get();
	}

	@Override
	public String deleteemployee(Integer employeeId) {
		employeerepositiory.deleteById(employeeId);
		return "Employee Deleted";
	}

	@Override
	public Employee updatePermision(Employee pEmployee) {
		return employeerepositiory.save(pEmployee);
	}

}
