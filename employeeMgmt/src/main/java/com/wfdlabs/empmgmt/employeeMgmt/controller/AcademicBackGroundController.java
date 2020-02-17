package com.wfdlabs.empmgmt.employeeMgmt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.wfdlabs.empmgmt.employeeMgmt.entity.AcademicBackGround;
import com.wfdlabs.empmgmt.employeeMgmt.service.AcademicBackGroundService;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/academicBackGround")
public class AcademicBackGroundController {

	@Autowired
	AcademicBackGroundService academicBackGroundService;

	/**
	 * This method is used to create AcademicBackGround details
	 * 
	 * @param academicBackGround
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AcademicBackGround> createAcademicBackGround(
			@RequestBody AcademicBackGround academicBackGround) {
		academicBackGround = academicBackGroundService.createAcademicBackGround(academicBackGround);
		return new ResponseEntity<>(academicBackGround, HttpStatus.CREATED);
	}

	/**
	 * This method is used to get the particular AcademicBackGround based on Id
	 * 
	 * @param Id
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<AcademicBackGround> getAcademicBackGroundId(@RequestParam Integer Id) {
		AcademicBackGround academicBackGround = null;
		boolean noElementFlag = false;
		try {
			academicBackGround = academicBackGroundService.getAcademicBackGroundId(Id);
		} catch (NoSuchElementException nsee) {
			noElementFlag = true;
		}
		if (noElementFlag || academicBackGround == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(academicBackGround, HttpStatus.OK);
	}

	/**
	 * This method is used to get the all AcademicBackGround Details
	 * 
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity<List<AcademicBackGround>> getAllAcademicBackGround() {
		List<AcademicBackGround> academicBackGroundList = academicBackGroundService.getAllAcademicBackGround();
		return new ResponseEntity<>(academicBackGroundList, HttpStatus.OK);
	}

	/**
	 * This methos is used to delete particulat AcademicBackGround details based on
	 * Id
	 * 
	 * @param Id
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity deleteAcademicBackGround(@RequestParam Integer Id) {
		academicBackGroundService.deleteAcademicBackGround(Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * This method is used to update the particular AcademicBackGround details
	 * 
	 * @param academicBackGround
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<AcademicBackGround> updateAcademicBackGround(
			@RequestBody AcademicBackGround academicBackGround) {
		academicBackGround = academicBackGroundService.updateAcademicBackGround(academicBackGround);
		return new ResponseEntity<>(academicBackGround, HttpStatus.OK);
	}
}
