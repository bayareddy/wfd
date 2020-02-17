package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Leave;
import com.wfdlabs.empmgmt.employeeMgmt.entity.LeaveStatus;
import com.wfdlabs.empmgmt.employeeMgmt.entity.LeaveType;

import java.util.List;

public interface LeaveService {

	public Leave createLeave(Leave leave);

	public Leave getById(Integer id);

	/**
	 * This method is used to create leavestatus details
	 * 
	 * @param leavestatus
	 * @return
	 */
	LeaveStatus createLeaveStatus(LeaveStatus leaveStatus);

	/**
	 * This method is used to get particular leavestatusId details
	 * 
	 * @param leaveId
	 * @return
	 */
	public LeaveStatus getLeaveStatus(Integer leaveId);

	/**
	 * this method is used to return all leavestatus details
	 * 
	 * @return
	 */
	public List<LeaveStatus> getAllLeaveStatus();

	/**
	 * This method is used to delete record based on leaveId
	 * 
	 * @param leaveId
	 * @return
	 */
	public String deleteLeaveStatus(Integer leaveId);

	/**
	 * This method is used to upadte leavestatus details
	 * 
	 * @param leaveType
	 * @return
	 */

	public LeaveStatus updateLeaveStatus(LeaveStatus leaveStatus);

	/**
	 * This method is used to create leavetype details
	 * 
	 * @param leaveType
	 * @return
	 */

	LeaveType createLeaveType(LeaveType leaveType);

	/**
	 * this method is used to return all leavetype details
	 * 
	 * @return
	 */

	public List<LeaveType> getAllLeaveType();

	/**
	 * This method is used to delete record based on leavesId
	 * 
	 * @param leaveId
	 * @return
	 */

	public String deleteLeaveType(Integer leaveId);

	/**
	 * This method is used to get particular leavetypeId details
	 * 
	 * @param leaveId
	 * @return
	 */
	public LeaveType getLeaveType(Integer leaveId);

	/**
	 * This method is used to upadte leavetype details
	 * 
	 * @param leaveType
	 * @return
	 */

	public LeaveType updateLeaveType(LeaveType leaveType);

}
