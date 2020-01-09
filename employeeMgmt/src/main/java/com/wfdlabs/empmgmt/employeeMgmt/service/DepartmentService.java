/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Department;

/**
 * @author DELL
 *
 */
public interface DepartmentService {

	Department create(Department pDepartment);

	Department get(Integer id);

	String delete(Integer id);

	Department update(Department pDepartment);

}
