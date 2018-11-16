package com.wfdlabs.empmgmt.employeeMgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/employee")
public class LoginController {
	@Autowired
	LoginService loginService;

	/**
	 * this methos is used to login employeepage based on employeeId and
	 * employeepassword
	 * 
	 * @param empId
	 * @param empPassword
	 * @return
	 */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Employee login(@RequestParam("employeeId") Integer empId, @RequestParam("password") String empPassword) {
		return loginService.login(empId, empPassword);
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
	public Employee validatePassword(@RequestParam("pancard") String employeePancard,
			@RequestParam("dateofBirth") String employeeDob, @RequestParam("employeeId") Integer empId)
			throws ParseException {
		return loginService.validatePassword(employeePancard, new SimpleDateFormat("dd/MM/yyyy").parse(employeeDob),empId);

	}

	/**
	 * this method is used to create employee details
	 * 
	 * @param employee
	 * @return employee details
	 */

	@RequestMapping(method = RequestMethod.POST)
	public List<Employee> createEmployee(@RequestBody Employee employee) {
		System.out.println("employee:" + employee);
		System.out.println("service scope:" + loginService);
		return loginService.createEmployee(employee);
	}

}