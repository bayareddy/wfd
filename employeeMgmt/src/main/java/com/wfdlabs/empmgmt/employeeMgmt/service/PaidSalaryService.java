package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.PaidSalary;
/**
 * 
 * @author Ashok
 *
 */

public interface PaidSalaryService {
	/**
	 * 
	 * @param ppaidSalary
	 * @return
	 */
	PaidSalary create(PaidSalary ppaidSalary);

	/**
	 * 
	 * @param id
	 * @return
	 */
	PaidSalary get(Integer id);

	/**
	 * 
	 * @param pPaidSalary
	 * @return
	 */
	PaidSalary update(PaidSalary pPaidSalary);

	/**
	 * 
	 * @param id
	 * @return
	 */
	String delete(Integer id);

}
