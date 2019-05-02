/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wfd.schoolmgt.schoolMgmt.Entity.Student;
import com.wfd.schoolmgt.schoolMgmt.Service.StudentService;

/**
 * @author Nithin
 *
 */
@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	/**
	 * This method is used to create StudentDetails
	 * 
	 * @param pAddress
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Student createStudent(@RequestBody Student pStudent) {
		return studentService.createStudent(pStudent);
	}
	/**
	 * This method is used to Get StudentDetails
	 * 
	 * @param pAddress
	 * @return
	 */
	@RequestMapping(value="/{studentId}",method=RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@PathVariable Integer studentId){
		Student student =null;
		Boolean noElement=false;
		try {
			student =studentService.getStudent(studentId);
		} catch (NoSuchElementException nsee) {
			noElement=true;
		}
		if(noElement || student==null) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(student,HttpStatus.OK);

	}
	/**
	 * This method is used to Update StudentDetails
	 * 
	 * @param pAddress
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student pStudent) {
		return studentService.updateStudent(pStudent);
	}
	/**
	 * This method is used to Delete StudentDetails
	 * 
	 * @param pAddress
	 * @return
	 */
	@RequestMapping(value="/{studentId}",method=RequestMethod.DELETE)
	public String deleteStudent(@PathVariable Integer studentId) {
		return studentService.deleteStudent(studentId);
	}
	

}
