package com.wfdlabs.empmgmt.employeeMgmt.service;

import java.util.List;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;

public interface EmployeeService {

	Employee createPermision(Employee pEmployee);

	Employee getemployee(Integer employeId);

	
	String deleteemployee(Integer employeeId);

	Employee updatePermision(Employee pEmployee);

	


}
