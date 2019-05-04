/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Service;

import com.wfd.schoolmgt.schoolMgmt.Entity.ExamType;

public interface ExamTypeService {
	/**
	 * This method is used to create ExamTypeDetails
	 * 
	 * @param pExamType
	 * @return
	 */

	ExamType createExamType(ExamType pExamType);
	/**
	 * This method is used to get ExamTypeDetails
	 * 
	 * @param pExamType
	 * @return
	 */

	ExamType getExamType(Integer examTypeId);
	/**
	 * This method is used to update ExamTypeDetails
	 * 
	 * @param pExamType
	 * @return
	 */

	ExamType updateExamType(ExamType pExamType);
	/**
	 * This method is used to delete ExamTypeDetails
	 * 
	 * @param pExamType
	 * @return
	 */

	String deleteExamType(Integer examTypeId);

	

}
