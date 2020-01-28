package com.wfdlabs.empmgmt.employeeMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wfdlabs.empmgmt.employeeMgmt.entity.EmployementHistory;

public interface EmployementHistoryRepository extends JpaRepository<EmployementHistory, Integer> {
	EmployementHistory findByEmployeeIdAndEmployeeCode(Integer id ,  String emploeer);

}
