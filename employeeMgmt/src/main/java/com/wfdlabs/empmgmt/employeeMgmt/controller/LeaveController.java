package com.wfdlabs.empmgmt.employeeMgmt.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Leave> createLeave(@RequestBody Leave leave) {
		leave.setUpdateDate(null);
		leave = leaveService.createLeave(leave);
		return new ResponseEntity<>(leave, HttpStatus.CREATED);
	}

	/**
	 * This class is used to get both leaveStatus details and leaveType details
	 * based on leaveId
	 * 
	 * @param id leaveId
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Leave> getById(@RequestParam Integer id) {
		Leave leave=null;
		boolean noElementFlag=false;
		try {
		leave= leaveService.getById(id);
		}
		catch (NoSuchElementException nsee) {
			noElementFlag=true;	
		}
		if(noElementFlag||leave==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(leave,HttpStatus.OK);
	}

	/**
	 * This method is used to create leavetype details
	 * 
	 * @param leaveType
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/leavetype", method = RequestMethod.POST)
	public ResponseEntity<LeaveType> createLeaveType(@RequestBody LeaveType leaveType) {
		System.out.println("LeaveType:" + leaveType);
		System.out.println("service scope:" + leaveService);
		leaveType.setUpdateDate(null);
		leaveType = leaveService.createLeaveType(leaveType);
		return new ResponseEntity<>(leaveType, HttpStatus.CREATED);
	}

	/**
	 * this method is used to return all leavetype details
	 * 
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/leavetype/getall", method = RequestMethod.GET)
	public ResponseEntity<List> getAllLeaveType() {
		List<LeaveType> leaveTypeList = leaveService.getAllLeaveType();
		if (leaveTypeList == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(leaveTypeList, HttpStatus.OK);
	}

	/**
	 * This method is used to delete record based on leavesId
	 * 
	 * @param leaveId
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/leavetype/delete", method = RequestMethod.DELETE)
	public ResponseEntity deleteLeaveType(@RequestParam Integer leaveId) {
		System.out.println("leaveTypeId:" + leaveId);
		System.out.println("service scope:" + leaveService);
		leaveService.deleteLeaveType(leaveId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	/**
	 * This method is used to get particular leavetypeId details
	 * 
	 * @param leaveId
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/leavetype/getId", method = RequestMethod.GET)
	public ResponseEntity<LeaveType> getLeaveType(@RequestParam Integer leaveId) {
		LeaveType leaveType=null;
		boolean noElementFlag=false;
		try {
			leaveType=leaveService.getLeaveType(leaveId);
		}
		catch (NoSuchElementException nsee) {
			noElementFlag =true;
		}
		if(noElementFlag||leaveType==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(leaveType,HttpStatus.OK);
	}

	/**
	 * This method is used to upadte leavetype details
	 * 
	 * @param leaveType
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/leavetype/update", method = RequestMethod.PUT)
	public ResponseEntity<LeaveType> updateLeaveType(@RequestBody LeaveType leaveType) {
		System.out.println("LeaveType:" + leaveType);
		System.out.println("service scope:" + leaveService);
		leaveType.setUpdateDate(new Date());
	     leaveType= leaveService.updateLeaveType(leaveType);
		return new ResponseEntity<>(leaveType,HttpStatus.OK);

	}

	/**
	 * This method is used to create leavestatus details
	 * 
	 * @param leavestatus
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/leavestatus", method = RequestMethod.POST)
	public ResponseEntity<LeaveStatus> createLeaveStatus(@RequestBody LeaveStatus leaveStatus) {
		System.out.println("LeaveStatus:" + leaveStatus);
		leaveStatus.setUpdateDate(null);
		leaveStatus = leaveService.createLeaveStatus(leaveStatus);
		return new ResponseEntity<>(leaveStatus, HttpStatus.CREATED);
	}

	/**
	 * This method is used to get particular leavestatusId details
	 * 
	 * @param leaveId
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/leavestatus/getid", method = RequestMethod.GET)
	public ResponseEntity<LeaveStatus> getLeaveStatus(@RequestParam Integer leaveId) {
		System.out.println("LeaveStatus:" + leaveId);
		LeaveStatus leaveStatus=null;
		boolean noElementFlag=false;
		try {
		 leaveStatus = leaveService.getLeaveStatus(leaveId);
		}
		catch(NoSuchElementException nsee) {
			noElementFlag=true;
		}
		if (noElementFlag||leaveStatus == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<LeaveStatus>(leaveStatus, HttpStatus.OK);
	}

	/**
	 * this method is used to return all leavestatus details
	 * 
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/leavestatus/getall", method = RequestMethod.GET)
	public  ResponseEntity<List> getAllLeaveStatus() {
		List<LeaveStatus> leavestatusList= leaveService.getAllLeaveStatus();
		return new ResponseEntity<>(leavestatusList,HttpStatus.OK);
	}

	/**
	 * This method is used to delete record based on leaveId
	 * 
	 * @param leaveId	
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/leavestatus/delete", method = RequestMethod.DELETE)
	public ResponseEntity deleteLeaveStatus(@RequestParam Integer leaveId) {
		System.out.println("leaveTypeId:" + leaveId);
		leaveService.deleteLeaveStatus(leaveId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * This method is used to upadte particular leavestatus details
	 * 
	 * @param leaveType
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/leavestatus/update", method = RequestMethod.PUT)
	public ResponseEntity<LeaveStatus> updateLeaveStatus(@RequestBody LeaveStatus leaveStatus) {
		System.out.println("LeaveStatus:" + leaveStatus);
		leaveStatus.setUpdateDate(new Date());
		leaveStatus= leaveService.updateLeaveStatus(leaveStatus);
		return new ResponseEntity<>(leaveStatus,HttpStatus.OK);
	}

}
