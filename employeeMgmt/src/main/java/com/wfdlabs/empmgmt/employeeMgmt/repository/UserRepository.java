/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wfdlabs.empmgmt.employeeMgmt.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
