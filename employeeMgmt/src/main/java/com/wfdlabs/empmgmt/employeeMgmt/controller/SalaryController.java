package com.wfdlabs.empmgmt.employeeMgmt.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wfdlabs.empmgmt.employeeMgmt.entity.Salary;
import com.wfdlabs.empmgmt.employeeMgmt.service.SalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryController {

	@Autowired
	SalaryService salaryService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Salary> createSalary(@RequestBody Salary salary) {
		salary.setUpdateDate(null);
		salary = salaryService.createSalary(salary);
		return new ResponseEntity<>(salary, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Salary> getSalary(@RequestParam Integer id) {
		Salary salary = null;
		boolean noElementFlag = false;
		try {
			salary = salaryService.getSalary(id);
		} catch (NoSuchElementException nsee) {
			noElementFlag = true;
		}
		if (noElementFlag || salary == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(salary, HttpStatus.OK);
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity<List<Salary>> getAllSalary() {
		List<Salary> salaryList = salaryService.getAllSalary();
		return new ResponseEntity<>(salaryList, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity deleteSalary(@RequestParam Integer id) {
		salaryService.deleteSalary(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Salary> updateSalary(@RequestBody Salary salary) {
		salary = salaryService.updateSalary(salary);
		return new ResponseEntity<>(salary, HttpStatus.OK);
	}
}
