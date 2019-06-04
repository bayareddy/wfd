/**
 * 
 */

package com.wfd.schoolmgt.schoolMgmt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.wfd.schoolmgt.schoolMgmt.Entity.TimeTable;
import com.wfd.schoolmgt.schoolMgmt.Repository.TimeTableRepository;
@Service
public class TimeTableServiceImpl implements TimeTableService {
	@Autowired
	TimeTableRepository timeTableRepository;
	
	/**
	 * This method is used to create TimeTableDetails
	 * 
	 * @param pTimeTable
	 * @return
	 */
	@Override
	public TimeTable createTimeTable(@RequestBody TimeTable pTimeTable) {

		return timeTableRepository.save(pTimeTable);
	}
	
	/**
	 * This method is used to create TimeTableDetails
	 * 
	 * @param pTimeTAble
	 * @return
	 */

	@Override
	public TimeTable getTimeTable(@PathVariable Integer timeTableId) {
		
		return timeTableRepository.findById(timeTableId).get();
	}
	
	/**
	 * This method is used to create TimeTableDetails
	 * 
	 * @param pTimeTable
	 * @return
	 */

	@Override
	public TimeTable updateTimeTable(@RequestBody TimeTable pTimeTable) {
		
		return timeTableRepository.save(pTimeTable);
	}
	
	/**
	 * This method is used to create TimeTaleDetails
	 * 
	 * @param pTimmeTable
	 * @return
	 */

	@Override
	public String deleteTimeTable(@RequestBody Integer timeTableId) {
		timeTableRepository.deleteById(timeTableId);
		return timeTableId+" Delete Successfully ";
	}

}
