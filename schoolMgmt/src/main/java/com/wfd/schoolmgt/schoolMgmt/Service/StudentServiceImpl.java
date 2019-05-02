/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfd.schoolmgt.schoolMgmt.Entity.Student;
import com.wfd.schoolmgt.schoolMgmt.Repository.StudentRepository;

/**
 * @author Nithin
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	/**
	 * This method is used to create StudentDetails
	 * 
	 * @param pAddress
	 * @return
	 */
	@Override
	public Student createStudent(Student pStudent) {

		return studentRepository.save(pStudent);
	}
	/**
	 * This method is used to Get StudentDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public Student getStudent(Integer studentId) {

		return studentRepository.findById(studentId).get();
	}

	/**
	 * This method is used to Update StudentDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public Student updateStudent(Student pStudent) {

		return studentRepository.save(pStudent);
	}

	/**
	 * This method is used to Delete StudentDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public String deleteStudent(Integer studentId) {
		studentRepository.deleteById(studentId);
		return "Student Deleted";
	}

}
