package com.wfdlabs.empmgmt.employeeMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.SalaryOffered;
import com.wfdlabs.empmgmt.employeeMgmt.repository.SalaryOfferedRepository;
import com.wfdlabs.empmgmt.employeeMgmt.service.SalaryOfferedService;

@Service
public class SalaryOfferedImpl implements SalaryOfferedService {
	@Autowired
	private SalaryOfferedRepository salaryofferedRepository;

	@Override
	/**
	 * This method is used to create salary offered and save details to
	 * salaryOffered
	 * 
	 * @param salaryOffered
	 * @return
	 */
	public SalaryOffered createSalaryOffered(SalaryOffered salaryOffered) {
		System.out.println("save record");
		return salaryofferedRepository.save(salaryOffered);
	}

	/**
	 * This method is used to update salary offered record based on employeeId .
	 * 
	 * @param employeeId
	 */
	public SalaryOffered updateSalaryOffered(SalaryOffered salaryOffered) {
		return salaryofferedRepository.save(salaryOffered);
	}

	/**
	 * This method is used to get role details based on employeeId
	 * 
	 * @param employeeId
	 * @return
	 */
	@Override
	public SalaryOffered getSalaryOffered(Integer employeeId) {

		return salaryofferedRepository.findById(employeeId).get();
	}

	/**
	 * This method is used to get all salary offered records
	 */
	@Override
	public List<SalaryOffered> getAllSalaryOffered() {
		return salaryofferedRepository.findAll();
	}

	/**
	 * This method is used to delete particular record based on rollId
	 */
	@Override
	public String deleteSalaryOffered(Integer employeeId) {
		System.out.println("delete employee history record");
		salaryofferedRepository.deleteById(employeeId);
		return "delete record successfully";
	}
}
