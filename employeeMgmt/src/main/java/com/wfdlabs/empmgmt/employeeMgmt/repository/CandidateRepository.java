package com.wfdlabs.empmgmt.employeeMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

}
