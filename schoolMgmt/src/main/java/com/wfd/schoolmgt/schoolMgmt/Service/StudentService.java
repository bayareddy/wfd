/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Service;

import com.wfd.schoolmgt.schoolMgmt.Entity.Student;

/**
 * @author Nithin
 *
 */
public interface StudentService {

	Student createStudent(Student pStudent);

	Student getStudent(Integer studentId);

	Student updateStudent(Student pStudent);

	String deleteStudent(Integer studentId);

}
