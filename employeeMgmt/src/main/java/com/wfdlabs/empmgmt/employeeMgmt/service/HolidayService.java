/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Holiday;

/**
 * @author DELL
 *
 */
public interface HolidayService {

	Holiday create(Holiday pHoliday);

	Holiday get(Integer id);

	Holiday update(Holiday pHoliday);

	String delete(Integer id);

}
