/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Candidate;

/**
 * @author DELL
 *
 */
public interface CandidateService {

	Candidate create(Candidate pCandidate);

	Candidate get(Integer id);

	Candidate update(Candidate pCandidate);

	String delete(Integer id);

}
