/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Department;
import com.wfdlabs.empmgmt.employeeMgmt.repository.DepartmentRepositiory;

/**
 * @author DELL
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	DepartmentRepositiory departmentRepositiory;

	@Override
	public Department create(Department pDepartment) {
		return departmentRepositiory.save(pDepartment);
	}

	@Override
	public Department get(Integer id) {
		return departmentRepositiory.findById(id).get();
	}

	@Override
	public String delete(Integer id) {
		departmentRepositiory.deleteById(id);
		return id + "Deleted Record Successfully";
	}

	@Override
	public Department update(Department pDepartment) {
		return departmentRepositiory.save(pDepartment);
		
	}

}
