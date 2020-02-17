package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Leave;
import com.wfdlabs.empmgmt.employeeMgmt.service.LeaveService;
import com.wfdlabs.empmgmt.employeeMgmt.repository.LeaveRepository;
import com.wfdlabs.empmgmt.employeeMgmt.entity.LeaveStatus;
import com.wfdlabs.empmgmt.employeeMgmt.entity.LeaveType;
import com.wfdlabs.empmgmt.employeeMgmt.repository.LeaveStatusRepository;
import com.wfdlabs.empmgmt.employeeMgmt.repository.LeaveTypeRepository;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveRepository leaverepository;

	@Autowired
	private LeaveStatusRepository leaveStatusRepository;

	@Autowired
	private LeaveTypeRepository leaveTypeRepository;

	@Override
	public Leave createLeave(Leave leave) {
		return leaverepository.save(leave);
	}

	@Override
	public Leave getById(Integer id) {
		return leaverepository.findById(id).get();
	}

	/**
	 * This method is used to create leavestatus details
	 * 
	 * @param leavestatus
	 * @return
	 */
	@Override
	public LeaveStatus createLeaveStatus(LeaveStatus leaveStatus) {
		System.out.println("Save leavestatus record ");
		return leaveStatusRepository.save(leaveStatus);
	}

	/**
	 * This method is used to get particular leavestatusId details
	 * 
	 * @param leaveId
	 * @return
	 */
	@Override
	public LeaveStatus getLeaveStatus(Integer leaveId) {
		return leaveStatusRepository.findById(leaveId).get();
	}

	/**
	 * this method is used to return all leaveStatus details
	 * 
	 * @return
	 */
	@Override
	public List<LeaveStatus> getAllLeaveStatus() {
		return leaveStatusRepository.findAll();
	}

	/**
	 * This method is used to delete record based on leaveId
	 * 
	 * @param leaveId
	 * @return
	 */

	@Override
	public String deleteLeaveStatus(Integer leaveId) {
		System.out.println("delete leavestatus record ");
		leaveStatusRepository.deleteById(leaveId);
		return "delete record successfully";
	}

	/**
	 * This method is used to upadte leavestatus details
	 * 
	 * @param leaveType
	 * @return
	 */

	public LeaveStatus updateLeaveStatus(LeaveStatus leaveStatus) {
		System.out.println("update and save leavestatus record");
		return leaveStatusRepository.save(leaveStatus);
	}

	/**
	 * This method is used to create leavetype details
	 * 
	 * @param leaveType
	 * @return
	 */

	@Override
	public LeaveType createLeaveType(LeaveType leaveType) {
		System.out.println("save leaveType record");
		return leaveTypeRepository.save(leaveType);

	}

	/**
	 * this method is used to return all leavetype details
	 * 
	 * @return
	 */

	@Override
	public List<LeaveType> getAllLeaveType() {
		return leaveTypeRepository.findAll();
	}

	/**
	 * This method is used to delete record based on leavesId
	 * 
	 * @param leaveId
	 * @return
	 */
	@Override
	public String deleteLeaveType(Integer leaveId) {
		System.out.println("delete leaveType record");
		leaveTypeRepository.deleteById(leaveId);
		return "deleted record successfully";
	}

	/**
	 * This method is used to get particular leavetypeId details
	 * 
	 * @param leaveId
	 * @return
	 */

	@Override
	public LeaveType getLeaveType(Integer leaveId) {
		return leaveTypeRepository.findById(leaveId).get();
	}

	/**
	 * This method is used to upadte leavetype details
	 * 
	 * @param leaveType
	 * @return
	 */

	@Override
	public LeaveType updateLeaveType(LeaveType leaveType) {
		System.out.println(" update & save leaveType record");
		return leaveTypeRepository.saveAndFlush(leaveType);
	}

}
