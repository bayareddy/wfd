/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;
import com.wfdlabs.empmgmt.employeeMgmt.service.LoginService;

/**
 * @author HP-PC
 *
 */
@RestController
@RequestMapping("/Login")
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Employee login(@RequestParam("employeeId") Integer empId, @RequestParam("password") String empPassword) {
		return loginService.login(empId, empPassword);
	}

}