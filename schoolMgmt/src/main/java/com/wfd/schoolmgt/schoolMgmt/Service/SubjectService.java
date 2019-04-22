/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Service;

import com.wfd.schoolmgt.schoolMgmt.Entity.Subject;

/**
 * @author Nithin
 *
 */
public interface SubjectService {

	/**
	 * This method is used to create Subject Details
	 * 
	 * @param pAddress
	 * @return
	 */

	Subject createSubject(Subject pSubject);

	/**
	 * This method is used to get Subject Details
	 * 
	 * @param pAddress
	 * @return
	 */
	Subject getSubject(Integer subjectId);

	/**
	 * This method is used to update Subject Details
	 * 
	 * @param pAddress
	 * @return
	 */
	Subject updateSubject(Subject pSubject);

	/**
	 * This method is used to Delete Subject Details
	 * 
	 * @param pAddress
	 * @return
	 */
	String deleteSubject(Integer subjectId);

}
