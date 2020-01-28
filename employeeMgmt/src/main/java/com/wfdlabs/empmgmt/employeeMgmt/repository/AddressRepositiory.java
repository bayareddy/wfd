/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Address;

/**
 * @author DELL
 *
 */
public interface AddressRepositiory extends JpaRepository<Address, Integer> {

}
