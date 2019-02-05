package com.wfdlabs.empmgmt.employeeMgmt.service;

import java.util.List;

import com.wfdlabs.empmgmt.employeeMgmt.entity.SalaryOffered;

public interface SalaryOfferedService {
	/**
	 * This method is used to create SalaryOffered
	 * 
	 * @param SalaryOffered
	 * @return
	 */
	public SalaryOffered createSalaryOffered(SalaryOffered salaryOffered);

	/**
	 * This method is used to update SalaryOffered record based on SalaryOffered id.
	 * 
	 * @param SalaryOffered
	 */
	public SalaryOffered updateSalaryOffered(SalaryOffered salaryOffered);

	/**
	 * This method is used to get all SalaryOffered details based on SalaryOffered
	 * id
	 * 
	 * @return SalaryOffered details
	 */
	List<SalaryOffered> getAllSalaryOffered();

	/**
	 * This method is used to delete SalaryOffered record based on SalaryOffered
	 * 
	 * @param employeeId
	 * @return
	 */

	String deleteSalaryOffered(Integer employeeId);

	/**
	 * This method is used to get SalaryOffered details based on employeeId
	 * 
	 * @param employeeId
	 * @return
	 */
	SalaryOffered getSalaryOffered(Integer employeeId);
}
