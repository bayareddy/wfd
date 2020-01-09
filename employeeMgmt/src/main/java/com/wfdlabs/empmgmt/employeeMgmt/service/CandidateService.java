package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Candidate;

public interface CandidateService {
	/**
	 * This method is used to create the CandidateDetails
	 * 
	 * @param pCandidate
	 * @return
	 */
	Candidate create(Candidate pCandidate);

	/**
	 * This method is used to get the CandidateDetails
	 * 
	 * @param pCandidate
	 * @return
	 */

	Candidate get(Integer id);

	/**
	 * This method is used to update the CandidateDetails
	 * 
	 * @param pCandidate
	 * @return
	 */

	Candidate update(Candidate pCandidate);

	/**
	 * This method is used to delete CandidateDetails
	 * 
	 * @param pCandidate
	 * @return
	 */

	String delete(Integer id);

}
