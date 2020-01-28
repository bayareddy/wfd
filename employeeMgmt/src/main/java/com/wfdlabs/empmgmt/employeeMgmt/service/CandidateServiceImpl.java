/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Candidate;
import com.wfdlabs.empmgmt.employeeMgmt.repository.CandidateRepositiory;

/**
 * @author DELL
 *
 */
@Service
public class CandidateServiceImpl  implements CandidateService{
	@Autowired
	CandidateRepositiory candidateRepositiory;

	@Override
	public Candidate create(Candidate pCandidate) {
		return candidateRepositiory.save(pCandidate);
	}

	@Override
	public Candidate get(Integer id) {
		return candidateRepositiory.findById(id).get();
	}

	@Override
	public Candidate update(Candidate pCandidate) {
		return candidateRepositiory.save(pCandidate);
	}

	@Override
	public String delete(Integer id) {
		candidateRepositiory.deleteById(id);
		return id + "Delete Record Succesfully";
	}

}
