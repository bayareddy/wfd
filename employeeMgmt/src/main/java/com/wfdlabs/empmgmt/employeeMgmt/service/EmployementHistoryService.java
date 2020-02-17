package com.wfdlabs.empmgmt.employeeMgmt.service;

import java.util.List;

import com.wfdlabs.empmgmt.employeeMgmt.entity.EmployementHistory;

public interface EmployementHistoryService {
	EmployementHistory createEmployementHistory(EmployementHistory employementHistory);

	EmployementHistory getEmployementHistory(Integer employeeId);

	List<EmployementHistory> getAllEmployementHistory();

	String deleteEmployementHistory(Integer employeeId);

	EmployementHistory updateEmployementHistory(EmployementHistory employementHistory);

	EmployementHistory getById(Integer employeeId);
}
