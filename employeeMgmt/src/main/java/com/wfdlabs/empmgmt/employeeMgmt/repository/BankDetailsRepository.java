package com.wfdlabs.empmgmt.employeeMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wfdlabs.empmgmt.employeeMgmt.entity.BankDetails;

public interface BankDetailsRepository extends JpaRepository<BankDetails, Integer> {

}