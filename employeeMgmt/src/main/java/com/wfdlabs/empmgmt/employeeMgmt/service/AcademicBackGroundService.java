package com.wfdlabs.empmgmt.employeeMgmt.service;

import java.util.List;

import com.wfdlabs.empmgmt.employeeMgmt.entity.AcademicBackGround;

public interface AcademicBackGroundService {
	/**
	 * This method is used to create AcademicBackGround details
	 * 
	 * @param academicBackGround
	 * @return
	 */

	public AcademicBackGround createAcademicBackGround(AcademicBackGround academicBackGround);

	/**
	 * This method is used to get the particular AcademicBackGround based on Id
	 * 
	 * @param Id
	 * @return
	 */

	public AcademicBackGround getAcademicBackGroundId(Integer Id);

	/**
	 * This methos is used to delete particulat AcademicBackGround details based on
	 * Id
	 * 
	 * @param Id
	 * @return
	 */

	public String deleteAcademicBackGround(Integer Id);

	/**
	 * This method is used to get the all AcademicBackGround Details
	 * 
	 */
	public List<AcademicBackGround> getAllAcademicBackGround();

	/**
	 * This method is used to update the particular AcademicBackGround details
	 * 
	 * @param academicBackGround
	 * @return
	 */
	public AcademicBackGround updateAcademicBackGround(AcademicBackGround academicBackGround);

}
