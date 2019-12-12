package com.wfdlabs.empmgmt.employeeMgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfdlabs.empmgmt.employeeMgmt.entity.PaidSalary;
import com.wfdlabs.empmgmt.employeeMgmt.service.PaidSalaryService;
/**
 * 
 * @author Ashok
 *
 */

@RequestMapping("/paidSalary")
@RestController
public class PaidSalaryController {

	@Autowired
	PaidSalaryService paidSalaryService;

	/**
	 * This method is used to create paidSalary
	 * @param ppaidSalary
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public PaidSalary createPaidSalary(@RequestBody PaidSalary ppaidSalary) {
		return paidSalaryService.create(ppaidSalary);
	}

	/**
	 * This method is used to get paid Salary based on id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{Id}", method = RequestMethod.GET)
	public PaidSalary getPaidSalary(@RequestParam Integer id) {
		return paidSalaryService.get(id);
	}

	/**
	 * This method is used to update Paid salary
	 * @param pPaidSalary
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public PaidSalary update(@RequestBody PaidSalary pPaidSalary) {
		return paidSalaryService.update(pPaidSalary);
	}

	/**
	 * This method is used to  delete paidSalary  based on id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public String delete(@RequestParam Integer id) {
		return paidSalaryService.delete(id);
	}
}