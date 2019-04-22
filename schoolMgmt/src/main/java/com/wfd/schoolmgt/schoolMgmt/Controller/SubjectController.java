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

import com.wfd.schoolmgt.schoolMgmt.Entity.Subject;
import com.wfd.schoolmgt.schoolMgmt.Service.SubjectService;

/**
 * @author Nithin
 *
 */
@RequestMapping("/subject")
@RestController
public class SubjectController {

	@Autowired
	SubjectService subjectService;

	/**
	 * This method is used to create Subject Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@RequestMapping(method = RequestMethod.POST)

	public Subject createSubject(@RequestBody Subject pSubject) {
		return subjectService.createSubject(pSubject);
	}

	/**
	 * This method is used to get Subject Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@RequestMapping(value = "/{subjectId}", method = RequestMethod.GET)
	public ResponseEntity<Subject> getSubject(@PathVariable Integer subjectId) {
		Subject subject = null;
		Boolean noSuchElement = false;
		try {
			subject = subjectService.getSubject(subjectId);
		} catch (NoSuchElementException nse) {
			noSuchElement = true;
		}
		if (noSuchElement || subject == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(subject, HttpStatus.OK);

	}

	/**
	 * This method is used to update Subject Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@RequestMapping(method = RequestMethod.PUT)

	public Subject updateSubject(@RequestBody Subject pSubject) {
		return subjectService.updateSubject(pSubject);
	}

	/**
	 * This method is used to delete Subject Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@RequestMapping(value = "/{subjectId}", method = RequestMethod.DELETE)
	public String deleteSubject(@PathVariable Integer subjectId) {
		return subjectService.deleteSubject(subjectId);

	}

}
