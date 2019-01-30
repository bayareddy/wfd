package com.wfdlabs.empmgmt.employeeMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.EmployementHistory;
import com.wfdlabs.empmgmt.employeeMgmt.repository.EmployementHistoryRepository;
import com.wfdlabs.empmgmt.employeeMgmt.service.EmployementHistoryService;

@Service
public class EmployementHistoryImpl implements EmployementHistoryService {
	@Autowired
	EmployementHistoryRepository employementHistoryRepository;

	@Override
	public EmployementHistory createEmployementHistory(EmployementHistory employementHistory) {
		System.out.println("Save record");
		return employementHistoryRepository.save(employementHistory);
	}

	@Override
	public EmployementHistory getEmployementHistory(Integer employeeId) {

		return employementHistoryRepository.findById(employeeId).get();
	}

	@Override
	public List<EmployementHistory> getAllEmployementHistory() {
		return employementHistoryRepository.findAll();
	}

	@Override
	public String deleteEmployementHistory(Integer employeeId) {
		System.out.println("delete employee history record");
		employementHistoryRepository.deleteById(employeeId);
		return "delete record successfully";
	}

	@Override
	public EmployementHistory updateEmployementHistory(EmployementHistory employementHistory) {
		System.out.println("update employee history record");
		return employementHistoryRepository.save(employementHistory);
	}

	@Override
	public EmployementHistory getById(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
