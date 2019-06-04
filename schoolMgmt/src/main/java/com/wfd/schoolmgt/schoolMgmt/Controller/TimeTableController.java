/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wfd.schoolmgt.schoolMgmt.Entity.TimeTable;
import com.wfd.schoolmgt.schoolMgmt.Service.TimeTableService;

@RequestMapping("/timeTable")
@RestController
public class TimeTableController {
	@Autowired
	TimeTableService timeTableService;
	
	/**
	 * This method is used to create TimeTableDetails
	 * 
	 * @param pTimeTable
	 * @return
	 */
	
	@RequestMapping(method = RequestMethod.POST)
	public TimeTable createTimeTable(@RequestBody TimeTable pTimeTable ) {
		return timeTableService.createTimeTable(pTimeTable) ;
		
	}
	/**
	 * This method is used to create TimeTableDetails
	 * 
	 * @param pTimeTable
	 * @return
	 */
	@RequestMapping(value = "/{timeTableId}", method = RequestMethod.GET)
	public ResponseEntity<TimeTable> getTimeTable(@PathVariable Integer timeTableId){
		TimeTable timeTable = null;
		 Boolean noSuchElement=false;
		 try {
			 timeTable = timeTableService.getTimeTable(timeTableId);
		 }catch (NoSuchElementException nsee) {
				noSuchElement=true;
			}
		 if(noSuchElement || timeTable==null) {
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 }
		return new ResponseEntity<>(timeTable,HttpStatus.OK);
		
	}
	/**
	 * This method is used to create TimeTableDetails
	 * 
	 * @param pTimeTable
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public TimeTable updateTimeTable(@RequestBody TimeTable pTimeTable) {
		return timeTableService.updateTimeTable(pTimeTable);
		
	}
	/**
	 * This method is used to create TimeTableDetails
	 * 
	 * @param pTimeTable
	 * @return
	 */
	
	@RequestMapping(value = "/{timeTableId}", method = RequestMethod.DELETE)
	
	
	public String deleteTimeTable(@PathVariable Integer timeTableId) {
		return timeTableService.deleteTimeTable(timeTableId);
		
	}
	

}
