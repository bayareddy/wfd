/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.controller;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Holiday;
import com.wfdlabs.empmgmt.employeeMgmt.service.HolidayService;

/**
 * @author DELL
 *
 */
@RestController
@RequestMapping(value="/holiday")
public class HolidayController {
	@Autowired
	HolidayService holidayService;
	/**
	 * This method is used to create holiday Details
	 * 
	 * @param pHoliday
	 * @return
	 */

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST)
	public Holiday create(@RequestBody Holiday pHoliday) {
		return holidayService.create(pHoliday);

	}
	/**
	 * This metho is used to get the holiday details
	 * 
	 * @param id
	 * @return
	 */

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{holiday}", method = RequestMethod.GET)
	public ResponseEntity<Holiday> get(@RequestParam Integer id) {
		Holiday holiday = null;
		Boolean noSuchElement = false;
		try {
			holiday = holidayService.get(id);
		} catch (NoResultException e) {
			noSuchElement = true;
		}
		if (noSuchElement || holiday == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(holiday, HttpStatus.OK);

	}
	/**
	 * This method is used to update the holiday details
	 * 
	 * @param pHoliday
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.PUT)
	public Holiday update(@RequestBody Holiday pHoliday) {
		return holidayService.update(pHoliday);

	}
	/**
	 * This method is used to delete the holiday details
	 * @param id
	 * @return
	 */

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{holiday}", method = RequestMethod.DELETE)
	public String delete(@RequestParam Integer id) {
		return holidayService.delete(id);

	}

}
