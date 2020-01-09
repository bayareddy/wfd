/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.PaidSalary;
import com.wfdlabs.empmgmt.employeeMgmt.repository.PaidSalaryRepositiory;

/**
 * @author Ashok
 *
 */
@Service
public class PaidSalaryServiceImpl implements PaidSalaryService {
	@Autowired
	PaidSalaryRepositiory paidSalaryRepositiory;

	/**
	 * 
	 */
	@Override
	public PaidSalary create(PaidSalary ppaidSalary) {
		return paidSalaryRepositiory.save(ppaidSalary);
	}

	@Override
	/**
	 * 
	 */
	public PaidSalary get(Integer id) {
		return paidSalaryRepositiory.findById(id).get();
	}

	/**
	 * 
	 */
	@Override
	public PaidSalary update(PaidSalary pPaidSalary) {
		return paidSalaryRepositiory.save(pPaidSalary);
	}

	/**
	 * 
	 */
	@Override
	public String delete(Integer id) {
		paidSalaryRepositiory.deleteById(id);
		return id + "Deleted Record Succesfully";
	}

	@Override
	public PaidSalary getByEmpIdYearMonth(Integer employeeId) {
		
		return paidSalaryRepositiory.findById(employeeId).get();
	}

	/*@Override
	public PaidSalary getByEmpIdYearMonth(Integer id, Integer year, String month) {
		return paidSalaryRepositiory.findById(id).get();
	}
*/
}
