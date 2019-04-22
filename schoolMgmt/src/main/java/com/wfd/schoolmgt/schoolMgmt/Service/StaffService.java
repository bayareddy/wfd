/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Service;

import com.wfd.schoolmgt.schoolMgmt.Entity.Staff;

/**
 * @author Nithin
 *
 */
public interface StaffService {

	/**
	 * This method is used to create Staff Details
	 * 
	 * @param pAddress
	 * @return
	 */

	Staff createStaff(Staff pStaff);

	/**
	 * This method is used to get Staff Details
	 * 
	 * @param pAddress
	 * @return
	 */
	Staff getStaff(Integer staffId);

	/**
	 * This method is used to update Staff Details
	 * 
	 * @param pAddress
	 * @return
	 */
	Staff updateStaff(Staff pStaff);

	/**
	 * This method is used to delete Staff Details
	 * 
	 * @param pAddress
	 * @return
	 */
	String deleteStaff(Integer staffId);

}
