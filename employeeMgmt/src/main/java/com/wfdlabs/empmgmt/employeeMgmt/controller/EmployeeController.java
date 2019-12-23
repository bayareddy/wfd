package com.wfdlabs.empmgmt.employeeMgmt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;
import com.wfdlabs.empmgmt.employeeMgmt.service.EmployeeService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	/**
	 * This class is used to post the employee details
	 * 
	 * @param employee
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee pEmployee) {
		return employeeService.createEmployee(pEmployee);

	}

	/**
	 * This class is used to post the employee details
	 * 
	 * @param employeeId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer employeeId) {
		Employee employee = null;
		Boolean noSuchElement = false;
		try {
			employee = employeeService.getEmployee(employeeId);
		} catch (NoResultException nsee) {
			noSuchElement = true;
		}
		if (noSuchElement || employee == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	/**
	 * This class is used to post the employee details
	 * 
	 * @param pEmployee
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee pEmployee) {
		return employeeService.updateEmployee(pEmployee);

	}

	/**
	 * This class is used to post the employee details
	 * 
	 * @param employeeId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Integer employeeId) {
		return employeeService.deleteEmployee(employeeId);

	}

}
