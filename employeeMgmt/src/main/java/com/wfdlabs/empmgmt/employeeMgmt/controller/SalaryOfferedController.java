package com.wfdlabs.empmgmt.employeeMgmt.controller;

import com.wfdlabs.empmgmt.employeeMgmt.entity.SalaryOffered;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wfdlabs.empmgmt.employeeMgmt.service.SalaryOfferedService;

@RestController
@RequestMapping("/SalaryOffered")
public class SalaryOfferedController {
	@Autowired
	SalaryOfferedService salaryOfferedService;

	@RequestMapping(method = RequestMethod.POST)
	public SalaryOffered createSalaryOffered(@RequestBody SalaryOffered salaryOffered) {
		return salaryOfferedService.createSalaryOffered(salaryOffered);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public SalaryOffered UpdateSalaryOffered(@RequestBody SalaryOffered salaryOffered) {
		return salaryOfferedService.updateSalaryOffered(salaryOffered);
	}

	@RequestMapping(method = RequestMethod.GET)
	public SalaryOffered getSalaryOffered(@RequestParam Integer employeeId) {
		System.out.println("SalaryOffered:" + employeeId);
		return salaryOfferedService.getSalaryOffered(employeeId);
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public List<SalaryOffered> getAllSalaryOffered() {
		return salaryOfferedService.getAllSalaryOffered();
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteSalaryOffered(@RequestParam Integer employeeId) {
		System.out.println("employeeId:" + employeeId);
		salaryOfferedService.deleteSalaryOffered(employeeId);
		return "delete record successfully";
	}

}
