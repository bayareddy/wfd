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

import com.wfd.schoolmgt.schoolMgmt.Entity.Staff;
import com.wfd.schoolmgt.schoolMgmt.Service.StaffService;

/**
 * @author Nithin
 *
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	StaffService staffService;

	/**
	 * This method is used to create Staff Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@RequestMapping(method = RequestMethod.POST)
	public Staff createStaff(@RequestBody Staff pStaff) {
		return staffService.createStaff(pStaff);
	}

	/**
	 * This method is used to get Staff Details
	 * 
	 * @param pAddress
	 * @return
	 */
	@RequestMapping(value = "/{staffId}", method = RequestMethod.GET)
	public ResponseEntity<Staff> getStaff(@PathVariable Integer staffId) {
		Staff staff=null;
		Boolean noSuchElement=false;
		try {
			staff=staffService.getStaff(staffId);
		} catch (NoSuchElementException nsee) {
			noSuchElement=true;
		}
		if(noSuchElement || staff==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(staff,HttpStatus.OK); 
	}

	/**
	 * This method is used to update Staff Details
	 * 
	 * @param pAddress
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Staff cupdateStaff(@RequestBody Staff pStaff) {
		return staffService.updateStaff(pStaff);
	}

	/**
	 * This method is used to Delete Staff Details
	 * 
	 * @param pAddress
	 * @return
	 */
	@RequestMapping(value = "/{staffId}", method = RequestMethod.DELETE)
	public String deleteStaff(@PathVariable Integer staffId) {
		return staffService.deleteStaff(staffId);
	}

}
