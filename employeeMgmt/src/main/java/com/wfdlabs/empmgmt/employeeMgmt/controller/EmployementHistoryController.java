package com.wfdlabs.empmgmt.employeeMgmt.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfdlabs.empmgmt.employeeMgmt.service.EmployementHistoryService;
import com.wfdlabs.empmgmt.employeeMgmt.entity.EmployementHistory;

@RestController
@RequestMapping("/EmployementHistory")
public class EmployementHistoryController {
	@Autowired
	private EmployementHistoryService employementHistoryService;

	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<EmployementHistory> createEmployeeHistory(
			@RequestBody EmployementHistory employementHistory) {
		System.out.println("EmployementHistory:" + employementHistory);
		employementHistory = employementHistoryService.createEmployementHistory(employementHistory);
		return new ResponseEntity<>(employementHistory, HttpStatus.CREATED);
	}
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<EmployementHistory> getEmployementHistory(@RequestParam Integer employeeId) {
		EmployementHistory employementHistory = null;
		boolean noElementFlag = false;
		try {
			employementHistory = employementHistoryService.getById(employeeId);
		} catch (NoSuchElementException nsee) {
			noElementFlag = true;
		}
		if (noElementFlag || employementHistory == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(employementHistory, HttpStatus.OK);
	}
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity<List<EmployementHistory>> getAllEmployementHistory() {
		List<EmployementHistory> employementHistoryList = employementHistoryService.getAllEmployementHistory();
		if (employementHistoryList == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(employementHistoryList, HttpStatus.OK);
	}
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployementHistory(@RequestParam Integer employeeId) {
		System.out.println("employeeId:" + employeeId);
		employementHistoryService.deleteEmployementHistory(employeeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	/*
	 * @CrossOrigin(origins="*")
	 * 
	 * @RequestMapping(method = RequestMethod.PUT) public
	 * ResponseEntity<EmployementHistory> updateEmployementHistory(
	 * 
	 * @RequestBody EmployementHistory employementHistory) {
	 * System.out.println("LeaveStatus:" + employementHistory); employementHistory =
	 * employementHistoryService.updateEmployementHistory(employementHistory);
	 * return new ResponseEntity<EmployementHistory>(HttpStatus.OK);
	 * 
	 * }
	 */

	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.PUT)
	public EmployementHistory updateEmployementHistory(@RequestBody EmployementHistory pEmployementHistory) {
		return employementHistoryService.updateEmployementHistory(pEmployementHistory);
		
	}

}
