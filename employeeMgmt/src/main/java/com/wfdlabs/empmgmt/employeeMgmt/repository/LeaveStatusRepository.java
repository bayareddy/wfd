package com.wfdlabs.empmgmt.employeeMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wfdlabs.empmgmt.employeeMgmt.entity.LeaveStatus;	

	public interface LeaveStatusRepository extends JpaRepository<LeaveStatus, Integer> {


}
