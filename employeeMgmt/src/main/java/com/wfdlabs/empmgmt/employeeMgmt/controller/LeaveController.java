package com.wfdlabs.empmgmt.employeeMgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Leave;
import com.wfdlabs.empmgmt.employeeMgmt.entity.LeaveType;
import com.wfdlabs.empmgmt.employeeMgmt.service.LeaveService;
import com.wfdlabs.empmgmt.employeeMgmt.entity.LeaveStatus;
import java.util.Date;

@RestController
@RequestMapping("leave")
public class LeaveController {

	@Autowired
	private LeaveService leaveService;

	/**
	 * This class is used to post the leave details
	 * 
	 * @param leave
	 * @return
	 */

	@RequestMapping(method = RequestMethod.POST)
	public Leave createLeave(@RequestBody Leave leave) {
		leave.setUpdateDate(null);
		return leaveService.createLeave(leave);
	}

	/**
	 * This class is used to get both leaveStatus details and leaveType details
	 * based on leaveId
	 * 
	 * @param id leaveId
	 * @return
	 */

	@RequestMapping(method = RequestMethod.GET)
	public Leave getById(@RequestParam Integer id) {
		return leaveService.getById(id);
	}

	/**
	 * This method is used to create leavetype details
	 * 
	 * @param leaveType
	 * @return
	 */

	@RequestMapping(value = "/leavetype", method = RequestMethod.POST)
	public LeaveType createLeaveType(@RequestBody LeaveType leaveType) {
		System.out.println("LeaveType:" + leaveType);
		System.out.println("service scope:" + leaveService);
		leaveType.setUpdateDate(null);
		return leaveService.createLeaveType(leaveType);
	}

	/**
	 * this method is used to return all leavetype details
	 * 
	 * @return
	 */
	@RequestMapping(value = "/leavetype/getall", method = RequestMethod.GET)
	public List<LeaveType> getAllLeaveType() {
		return leaveService.getAllLeaveType();
	}

	/**
	 * This method is used to delete record based on leavesId
	 * 
	 * @param leaveId
	 * @return
	 */

	@RequestMapping(value = "/leavetype/delete", method = RequestMethod.DELETE)
	public String deleteLeaveType(@RequestParam Integer leaveId) {
		System.out.println("leaveTypeId:" + leaveId);
		System.out.println("service scope:" + leaveService);
		leaveService.deleteLeaveType(leaveId);
		return "delete record sucessfully";

	}

	/**
	 * This method is used to get particular leavetypeId details
	 * 
	 * @param leaveId
	 * @return
	 */

	@RequestMapping(value = "/leavetype/getId", method = RequestMethod.GET)
	public LeaveType getLeaveType(@RequestParam Integer leaveId) {
		return leaveService.getLeaveType(leaveId);
	}

	/**
	 * This method is used to upadte leavetype details
	 * 
	 * @param leaveType
	 * @return
	 */

	@RequestMapping(value = "/leavetype/update", method = RequestMethod.PUT)
	public LeaveType updateLeaveType(@RequestBody LeaveType leaveType) {
		System.out.println("LeaveType:" + leaveType);
		System.out.println("service scope:" + leaveService);
		leaveType.setUpdateDate(new Date());
		return leaveService.updateLeaveType(leaveType);

	}

	/**
	 * This method is used to create leavestatus details
	 * 
	 * @param leavestatus
	 * @return
	 */
	@RequestMapping(value = "/leavestatus", method = RequestMethod.POST)
	public LeaveStatus createLeaveStatus(@RequestBody LeaveStatus leaveStatus) {
		System.out.println("LeaveStatus:" + leaveStatus);
		leaveStatus.setUpdateDate(null);
		return leaveService.createLeaveStatus(leaveStatus);
	}

	/**
	 * This method is used to get particular leavestatusId details
	 * 
	 * @param leaveId
	 * @return
	 */
	@RequestMapping(value = "/leavestatus/getid", method = RequestMethod.GET)
	public LeaveStatus getLeaveStatus(@RequestParam Integer leaveId) {
		System.out.println("LeaveStatus:" + leaveId);
		return leaveService.getLeaveStatus(leaveId);
	}

	/**
	 * this method is used to return all leavestatus details
	 * 
	 * @return
	 */
	@RequestMapping(value = "/leavestatus/getall", method = RequestMethod.GET)
	public List<LeaveStatus> getAllLeavetype() {
		return leaveService.getAllLeaveStatus();
	}

	/**
	 * This method is used to delete record based on leaveId
	 * 
	 * @param leaveId
	 * @return
	 */
	@RequestMapping(value = "/leavestatus/delete", method = RequestMethod.DELETE)
	public String deleteLeaveStatus(@RequestParam Integer leaveId) {
		System.out.println("leaveTypeId:" + leaveId);
		leaveService.deleteLeaveStatus(leaveId);
		return "delete record successfully";
	}

	/**
	 * This method is used to upadte particular leavestatus details
	 * 
	 * @param leaveType
	 * @return
	 */

	@RequestMapping(value = "/leavestatus/update", method = RequestMethod.PUT)
	public LeaveStatus updateLeaveStatus(@RequestBody LeaveStatus leaveStatus) {
		System.out.println("LeaveStatus:" + leaveStatus);
		leaveStatus.setUpdateDate(new Date());
		return leaveService.updateLeaveStatus(leaveStatus);
	}

}
