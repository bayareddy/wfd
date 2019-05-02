/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wfd.schoolmgt.schoolMgmt.Entity.Student;

/**
 * @author Nithin
 *
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
