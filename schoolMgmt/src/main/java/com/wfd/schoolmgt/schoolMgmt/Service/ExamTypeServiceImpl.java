/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.wfd.schoolmgt.schoolMgmt.Entity.ExamType;
import com.wfd.schoolmgt.schoolMgmt.Repository.ExamTypeRepository;

@Service
public class ExamTypeServiceImpl implements ExamTypeService {
	@Autowired
	ExamTypeRepository examTypeRepository;
	
	/**
	 * This method is used to get ExamTypeDetails
	 * 
	 * @param pExamType
	 * @return
	 */
	@Override
	public ExamType createExamType(@RequestBody ExamType pExamType) {
		return examTypeRepository.save(pExamType);
	}
	/**
	 * This method is used to get ExamTypeDetails
	 * 
	 * @param pExamType
	 * @return
	 */

	@Override
	public ExamType getExamType(@PathVariable Integer examTypeId) {
		return examTypeRepository.findById(examTypeId).get();
	}
	/**
	 * This method is used to update ExamTypeDetails
	 * 
	 * @param pExamType
	 * @return
	 */

	@Override
	public ExamType updateExamType(@RequestBody ExamType pExamType) {
		return examTypeRepository.save(pExamType);
	}
	/**
	 * This method is used to delete ExamTypeDetails
	 * 
	 * @param pExamType
	 * @return
	 */

	@Override
	public String deleteExamType(@PathVariable Integer examTypeId) {
		examTypeRepository.deleteById(examTypeId);
		return examTypeId + "Delete Successfully";
	}

}
