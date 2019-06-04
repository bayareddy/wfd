/**
 * 
 */

package com.wfd.schoolmgt.schoolMgmt.Service;

import com.wfd.schoolmgt.schoolMgmt.Entity.TimeTable;

public interface TimeTableService  {
	
	/**
	 * This method is used to create TimeTableDetails
	 * 
	 * @param pTimeTable
	 * @return
	 */

	TimeTable createTimeTable(TimeTable pTimeTable);
	
	/**
	 * This method is used to create TimeTableDetails
	 * 
	 * @param pTimeTable
	 * @return
	 */

	TimeTable getTimeTable(Integer timeTableId);
	
	/**
	 * This method is used to create TimeTableDetails
	 * 
	 * @param pTimeTable
	 * @return
	 */

	TimeTable updateTimeTable(TimeTable pTimeTable);
	
	/**
	 * This method is used to create TimeTableDetails
	 * 
	 * @param pTimeTable
	 * @return
	 */

	String deleteTimeTable(Integer timeTableId);

	

}
