package com.wfdlabs.empmgmt.employeeMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wfdlabs.empmgmt.employeeMgmt.entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {

}

