/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Service;

import com.wfd.schoolmgt.schoolMgmt.Entity.Marks;

public interface MarksService {
	/**
	 * This method is used to create Marks Details
	 * 
	 * @param pMarks
	 * @return
	 */
	
	Marks createMarks(Marks pMarks);
	
	/**
	 * This method is used to get Marks Details
	 * 
	 * @param pMarks
	 * @return
	 */
	
	Marks getMarks(Integer marksId);
	
	/**
	 * This method is used to update Marks Details
	 * 
	 * @param pMarks
	 * @return
	 */
	
	Marks updateMarks(Marks pMarks);
	
	/**
	 * This method is used to delete Marks Details
	 * 
	 * @param pMarks
	 * @return
	 */
	String deleteMarks(Integer marksId);

}
