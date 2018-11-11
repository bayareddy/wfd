/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;

/**
 * @author HP-PC
 *
 */
public interface LoginService {
	

	public Employee login(Integer empId, String empPassword);

}
