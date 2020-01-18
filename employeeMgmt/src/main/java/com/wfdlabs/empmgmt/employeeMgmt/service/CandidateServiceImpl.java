package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Candidate;
import com.wfdlabs.empmgmt.employeeMgmt.repository.CandidateRepository;

@Service
public class CandidateServiceImpl implements CandidateService {
	@Autowired
	CandidateRepository candidateRepository;

	/**
	 * This method is used to create CandidateDetails
	 * 
	 * @param pCandidate
	 * @return
	 */
	@Override
	public Candidate create(Candidate pCandidate) {
		return candidateRepository.save(pCandidate);
	}

	/**
	 * This method is used to get the CandidateDetails
	 * 
	 * @param pCandidate
	 * @return
	 */
	@Override
	public Candidate get(Integer id) {
		return candidateRepository.findById(id).get();
	}

	/**
	 * This method is used to update the CandidateDetails
	 * 
	 * @param pCandidate
	 * @return
	 */
	@Override
	public Candidate update(Candidate pCandidate) {
		return candidateRepository.save(pCandidate);
	}

	/**
	 * This method is used to delete CandidateDetails
	 * 
	 * @param pCandidate
	 * @return
	 */
	@Override
	public String delete(Integer id) {
		candidateRepository.deleteById(id);
		return id + " Delete Successfully";
	}

}
