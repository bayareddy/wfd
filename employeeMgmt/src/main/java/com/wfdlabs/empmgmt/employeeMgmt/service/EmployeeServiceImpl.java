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
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeerepositiory;

	
	@Override
	public Employee createEmployee(@RequestBody Employee pEmployee) {
		return employeerepositiory.save(pEmployee);
	}

	@Override
	public Employee getEmployee(@PathVariable Integer employeeId) {
		return employeerepositiory.findById(employeeId).get();
	}

	@Override
	public Employee updateEmployee(@RequestBody Employee pEmployee) {
		return employeerepositiory.save(pEmployee);
	}

	@Override
	public String deleteEmployee(@PathVariable Integer employeeId) {
		employeerepositiory.deleteById(employeeId);
		return employeeId + " Delete Successfully";
	}

	@Override
	public Employee generatePdf(Integer employeeId) {
		System.out.println("Success");
		return employeerepositiory.findById(employeeId).get();
	}

}
