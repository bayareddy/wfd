/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Holiday;

/**
 * @author syam prasad
 *
 */
public interface HolidayService {
	/**
	 * This method is used to create holiday details
	 * 
	 * @param pHoliday
	 * @return
	 */
	Holiday create(Holiday pHoliday);

	/**
	 * This method is used to get the holiday details
	 * 
	 * @param id
	 * @return
	 */

	Holiday get(Integer id);

	/**
	 * This method is used to update holiday details
	 * 
	 * @param pHoliday
	 * @return
	 */

	Holiday update(Holiday pHoliday);

	/**
	 * This method is used to delete the holiday details
	 * 
	 * @param id
	 * @return
	 */

	String delete(Integer id);

}
