/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.wfd.schoolmgt.schoolMgmt.Entity.Marks;
import com.wfd.schoolmgt.schoolMgmt.Repository.MarksRepository;


@Service
public class MarksServiceImpl implements MarksService {
	
	@Autowired
	MarksRepository marksRepository;
	
	/**
	 * This method is used to create Marks Details
	 * 
	 * @param pMarks
	 * @return
	 */
	@Override
	public Marks createMarks(@RequestBody Marks pMarks) {
		return marksRepository.save(pMarks);
	}
	
	/**
	 * This method is used to get Marks Details
	 * 
	 * @param pMarks
	 * @return
	 */
	@Override
	public Marks getMarks(@PathVariable Integer marksId) {
		return marksRepository.findById(marksId).get();
	}
	
	/**
	 * This method is used to update Marks Details
	 * 
	 * @param pMarks
	 * @return
	 */
	public Marks updateMarks(@RequestBody Marks pMarks) {
		return marksRepository.save(pMarks);
	}
	
	/**
	 * This method is used to delete Marks Details
	 * 
	 * @param pMarks
	 * @return
	 */
	public String deleteMarks(@PathVariable Integer marksId) {
		marksRepository.deleteById(marksId);
		return marksId + " Delete Sucessfully";
	}
	
}
