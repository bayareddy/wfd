package com.wfdlabs.empmgmt.employeeMgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;
import com.wfdlabs.empmgmt.employeeMgmt.service.LoginService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Maheswari
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/employee")
public class LoginController {
	@Autowired
	LoginService loginService;

	/**
	 * this method is used to login employeepage based on employeeId and
	 * employeepassword
	 * 
	 * @param empId
	 * @param empPassword
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public  ResponseEntity<Employee> login(@RequestParam("employeeId") Integer empId, @RequestParam("password") String empPassword) {
		Employee employee= loginService.login(empId, empPassword);
		if(employee==null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}

	/**
	 * This method is used to validate password by employeeId, pancard and
	 * dateofbirth
	 * 
	 * @param employeeId
	 * @param employeePancard
	 * @param employeeDob
	 * @return
	 */

	@RequestMapping(value = "/forget", method = RequestMethod.GET)
	public  ResponseEntity<Employee> validatePassword(@RequestParam("pancard") String employeePancard,
			@RequestParam("dateofBirth") String employeeDob, @RequestParam("employeeId") Integer empId)
			throws ParseException {
		Employee employee= loginService.validatePassword(employeePancard, new SimpleDateFormat("dd/MM/yyyy").parse(employeeDob),empId);
        if(employee==null) {
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        	
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
	}

	/**
	 * this method is used to create employee details
	 * 
	 * @param employee
	 * @return employee details
	 */

	/*
	 * @RequestMapping(method = RequestMethod.POST) public ResponseEntity<List>
	 * createEmployee(@RequestBody Employee employee) {
	 * System.out.println("employee:" + employee);
	 * System.out.println("service scope:" + loginService); List<Employee>
	 * employeeList= loginService.createEmployee(employee); return new
	 * ResponseEntity<>(employeeList,HttpStatus.CREATED); }
	 */

}