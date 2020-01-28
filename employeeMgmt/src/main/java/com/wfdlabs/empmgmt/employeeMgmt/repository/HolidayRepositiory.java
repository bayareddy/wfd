/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Holiday;

/**
 * @author DELL
 *
 */
public interface HolidayRepositiory extends JpaRepository<Holiday	, Integer> {

}
