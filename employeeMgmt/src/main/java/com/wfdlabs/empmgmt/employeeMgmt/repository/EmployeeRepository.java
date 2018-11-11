package com.wfdlabs.empmgmt.employeeMgmt.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	Employee findByEmployeeIdAndPassword(Integer empId, String empPassword);
	
}
