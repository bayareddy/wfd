/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Holiday;

/**
 * @author syam prasad
 *
 */
public interface HolidayRepository extends JpaRepository<Holiday, Integer> {

}
