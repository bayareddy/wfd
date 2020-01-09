/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Department;
import com.wfdlabs.empmgmt.employeeMgmt.service.DepartmentService;

/**
 * @author DELL
 *
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@RequestMapping(method = RequestMethod.POST)
	public Department create(@RequestBody Department pDepartment) {
		return departmentService.create(pDepartment);
	}

	@RequestMapping(value = {"/id" }, method = RequestMethod.GET)
	public ResponseEntity<Department> get(@RequestParam Integer id) {
		Department department = null;
		Boolean noSuchvalue = false;
		try {
			department = departmentService.get(id);
		} catch (NoSuchElementException nsee) {
			noSuchvalue = true;
		}
		if (noSuchvalue || department == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(department, HttpStatus.OK);
	}

	@RequestMapping(value = { "/id" }, method = RequestMethod.DELETE)
	public String delete(@RequestParam Integer id) {
		return departmentService.delete(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Department update(@RequestBody Department pDepartment) {
		return departmentService.update(pDepartment);
	}

}
