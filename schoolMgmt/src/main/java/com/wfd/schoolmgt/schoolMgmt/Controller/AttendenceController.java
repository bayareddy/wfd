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

import com.wfd.schoolmgt.schoolMgmt.Entity.Attendence;
import com.wfd.schoolmgt.schoolMgmt.Service.AttendenceService;

/**
 * @author Nithin
 *
 */
@RestController
@RequestMapping("/attendence")
public class AttendenceController {

	@Autowired
	AttendenceService attendenceService;

	@RequestMapping(method = RequestMethod.POST)
	public Attendence createAttendence(@RequestBody Attendence pAttendence) {
		return attendenceService.createAttendence(pAttendence);
	}

	@RequestMapping(value = "/{attendenceId}", method = RequestMethod.GET)
	public ResponseEntity<Attendence> getAttendence(@PathVariable Integer attendenceId) {
		Attendence attendence = null;
		Boolean noElement = false;
		try {
			attendence = attendenceService.getAttendence(attendenceId);
		} catch (NoSuchElementException nsee) {
			noElement = true;
		}
		if (noElement || attendence == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(attendence, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Attendence updateAttendence(@RequestBody Attendence pAttendence) {
		return attendenceService.updateAttendence(pAttendence);
	}

	@RequestMapping(value = "/{attendenceId}", method = RequestMethod.DELETE)
	public String deleteAttendence(@PathVariable Integer attendenceId) {
		return attendenceService.deleteAttedence(attendenceId);
	}

}
