/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Candidate;

/**
 * @author DELL
 *
 */
public interface CandidateRepositiory extends JpaRepository<Candidate, Integer> {

}
