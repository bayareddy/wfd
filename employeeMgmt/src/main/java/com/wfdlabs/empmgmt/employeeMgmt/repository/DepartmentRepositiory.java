/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Department;

/**
 * @author DELL
 *
 */
public interface DepartmentRepositiory extends JpaRepository<Department, Integer>{

}
