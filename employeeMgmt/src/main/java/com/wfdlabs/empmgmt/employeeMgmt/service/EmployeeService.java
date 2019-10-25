package com.wfdlabs.empmgmt.employeeMgmt.service;

//import java.util.List;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee pEmployee);

	Employee getEmployee(Integer employeeId);

	Employee updateEmployee(Employee pEmployee);

	String deleteEmployee(Integer employeeId);

	Employee generatePdf(Integer employeeId);

	


	

	


}
