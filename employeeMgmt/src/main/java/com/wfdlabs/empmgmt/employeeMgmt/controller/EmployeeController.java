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
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;
import com.wfdlabs.empmgmt.employeeMgmt.service.EmployeeService;


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
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee pEmployee) {
		return employeeService.createEmployee(pEmployee);
		
	}
	/**
	 * This class  is used to post the employee details
	 * @param employeeId
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/{employeeId}",method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer employeeId){
		Employee employee = null;
		Boolean noSuchElement = false;
		try {
			employee = employeeService.getEmployee(employeeId);
		}catch (NoResultException nsee) {
			noSuchElement = true;
		}
		if(noSuchElement || employee==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	/**
	 * This class  is used to post the employee details
	 * @param pEmployee
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee pEmployee) {
		return employeeService.updateEmployee(pEmployee);
		
	}
	/**
	 * This class  is used to post the employee details
	 * @param employeeId
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/{employeeId}",method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Integer employeeId) {
		return employeeService.deleteEmployee(employeeId);
		
	
	}
	@RequestMapping(value = "/getPdf", method = RequestMethod.GET, produces = "application/pdf")
	public ResponseEntity<byte[]> getPdf() {
		FileInputStream fileStream;
	//	File file = new File("D:\\Syam.pdf");

		try {
			File file=ResourceUtils.getFile("classpath:Anand.pdf");
			fileStream = new FileInputStream(file);
			byte contents[] = new byte[(int) file.length()];
			fileStream.read(contents);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.parseMediaType("application/pdf"));
			String filename = "Anand.pdf";
			headers.setContentDispositionFormData(filename, filename);
			ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
			return response;
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
		return null;
	}
}
		


