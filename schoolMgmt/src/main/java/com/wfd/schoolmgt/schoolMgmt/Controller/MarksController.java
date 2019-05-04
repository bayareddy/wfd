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

import com.wfd.schoolmgt.schoolMgmt.Entity.Marks;
import com.wfd.schoolmgt.schoolMgmt.Service.MarksService;

@RequestMapping("/marks")
@RestController
public class MarksController {
	@Autowired
	MarksService marksService;
	
	/**
	 * This method is used to create Marks Details
	 * 
	 * @param pMarks
	 * @return
	 */
	
	@RequestMapping(method = RequestMethod.POST)
	public Marks createMarks(@RequestBody Marks pMarks) {
		return marksService.createMarks(pMarks);
		
	}
	
	/**
	 * This method is used to get Marks Details
	 * 
	 * @param pMarks
	 * @return
	 */
	
	@RequestMapping(value = "/{marksId}" , method = RequestMethod.GET)
	public ResponseEntity<Marks> getMarks(@PathVariable Integer marksId) {
		Marks marks=null;
		Boolean noSuchElement=false;
		try {
			marks= marksService.getMarks(marksId);
		} catch (NoSuchElementException nsee) {
			noSuchElement=true;
		}
		if(noSuchElement || marks==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(marks,HttpStatus.OK);
	}
	//public Marks getMarkas(@PathVariable Integer marksId) {
		//return marksService.getMarks(marksId);
	//}
	
	/**
	 * This method is used to update Marks Details
	 * 
	 * @param pMarks
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Marks updateMarks(@RequestBody Marks pMarks) {
		return marksService.updateMarks(pMarks);	
	}
	
	/**
	 * This method is used to delete Marks Details
	 * 
	 * @param pMarks
	 * @return
	 */
	
	 @RequestMapping(value = "/{marksId}", method = RequestMethod.DELETE)
	public String deleteMarks(@PathVariable Integer marksId) {
		return marksService.deleteMarks(marksId);
	}
	

}
