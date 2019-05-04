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

import com.wfd.schoolmgt.schoolMgmt.Entity.ExamType;
import com.wfd.schoolmgt.schoolMgmt.Service.ExamTypeService;

@RequestMapping("/examtype")
@RestController
public class ExamTypeConroller {
	@Autowired
	ExamTypeService examTypeService;
	
	/**
	 * This method is used to create ExamTypeDetails
	 * 
	 * @param pExamType
	 * @return
	 */
	
	@RequestMapping(method = RequestMethod.POST)
	 public ExamType createExamType(@RequestBody ExamType pExamType) {
		  return examTypeService.createExamType(pExamType);
		 }
	
	/**
	 * This method is used to get ExamTypeDetails
	 * 
	 * @param pExamType
	 * @return
	 */
	 @RequestMapping(value = "/{examTypeId}", method = RequestMethod.GET)
	 public ResponseEntity<ExamType> getExamType(@PathVariable Integer examTypeId){
		 ExamType examType = null;
		 Boolean noSuchElement=false;
		 try {
				examType= examTypeService.getExamType(examTypeId);
			} catch (NoSuchElementException nsee) {
				noSuchElement=true;
			}
			if(noSuchElement || examType==null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<>(examType,HttpStatus.OK);
	 //public ExamType getExamType(@PathVariable Integer examTypeId) {
	  //return examTypeService.getExamType(examTypeId);
	 }
	 
	 /**
		 * This method is used to update ExamTypeDetails
		 * 
		 * @param pExamType
		 * @return
		 */
   @RequestMapping(method = RequestMethod.PUT)
   public ExamType updateExamType(@RequestBody ExamType pExamType) {
   	  return examTypeService.updateExamType(pExamType);
   	 }
   
   /**
	 * This method is used to delete ExamTypeDetails
	 * 
	 * @param pExamType
	 * @return
	 */
  @RequestMapping(value = "/{examTypeId}", method = RequestMethod.DELETE)
   public String deleteExamType(@PathVariable Integer examTypeId) {
   	  return examTypeService.deleteExamType(examTypeId);
   	 }

	


}
