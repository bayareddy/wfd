package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.wfdlabs.empmgmt.employeeMgmt.entity.AcademicBackGround;
import com.wfdlabs.empmgmt.employeeMgmt.repository.AcademicBackGroundRepository;
import com.wfdlabs.empmgmt.employeeMgmt.service.AcademicBackGroundService;

@Service
public class AcademicBackGroundServiceImpl implements AcademicBackGroundService {

	@Autowired
	private AcademicBackGroundRepository academicBackGroundRepository;

	/**
	 * This method is used to create AcademicBackGround details
	 * 
	 * @param academicBackGround
	 * @return
	 */
	@Override
	public AcademicBackGround createAcademicBackGround(AcademicBackGround academicBackGround) {
		System.out.println("Save department recrod");
		return academicBackGroundRepository.save(academicBackGround);
	}

	/**
	 * This method is used to get the particular AcademicBackGround based on Id
	 * 
	 * @param Id
	 * @return
	 */
	@Override
	public AcademicBackGround getAcademicBackGroundId(Integer Id) {
		return academicBackGroundRepository.findById(Id).get();
	}

	/**
	 * This method is used to update the particular AcademicBackGround details
	 * 
	 * @param academicBackGround
	 * @return
	 */

	@Override
	public AcademicBackGround updateAcademicBackGround(AcademicBackGround academicBackGround) {
		return academicBackGroundRepository.save(academicBackGround);
	}

	/**
	 * This method is used to get the all AcademicBackGround Details
	 * 
	 */
	@Override
	public List<AcademicBackGround> getAllAcademicBackGround() {
		return academicBackGroundRepository.findAll();
	}

	/**
	 * This methos is used to delete particulat AcademicBackGround details based on
	 * Id
	 * 
	 * @param Id
	 * @return
	 */

	@Override
	public String deleteAcademicBackGround(Integer Id) {
		academicBackGroundRepository.deleteById(Id);
		return "deleted record sucessfully";
	}
}
