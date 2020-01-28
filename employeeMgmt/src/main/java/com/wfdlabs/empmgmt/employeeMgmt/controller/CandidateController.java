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

import com.wfdlabs.empmgmt.employeeMgmt.entity.Candidate;
import com.wfdlabs.empmgmt.employeeMgmt.service.CandidateService;

/**
 * @author DELL
 *
 */
@RestController
@RequestMapping(value = "/Candidate")
public class CandidateController {
	@Autowired
	CandidateService candidateService;

	/**
	 * This method is used to create CandidateDetails
	 * 
	 * @param pCandidate
	 * @return
	 */

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST)
	public Candidate create(@RequestBody Candidate pCandidate) {
		return candidateService.create(pCandidate);

	}

	/**
	 * This method is used to get the CandidateDetails
	 * 
	 * @param pCandidate
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{candidate}", method = RequestMethod.GET)
	public ResponseEntity<Candidate> get(@RequestParam Integer id) {
		Candidate candidate = null;
		Boolean noSuchElement = false;
		try {
			candidate = candidateService.get(id);
		} catch (NoResultException e) {
			noSuchElement = true;
		}
		if (noSuchElement || candidate == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(candidate, HttpStatus.OK);

	}

	/**
	 * This method is used to update CandidateDetails
	 * 
	 * @param pCandidate
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.PUT)
	public Candidate update(@RequestBody Candidate pCandidate) {
		return candidateService.update(pCandidate);

	}

	/**
	 * This method is used to delete CandidateDetails
	 * 
	 * @param pCandidate
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{candidate}", method = RequestMethod.DELETE)
	public String delete(@RequestParam Integer id) {
		return candidateService.delete(id);

	}

}
