/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfd.schoolmgt.schoolMgmt.Entity.Subject;
import com.wfd.schoolmgt.schoolMgmt.Repository.Subjectrepository;

/**
 * @author Nithin
 *
 */
@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	Subjectrepository subjectRepository;

	/**
	 * This method is used to create Subject Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public Subject createSubject(Subject pSubject) {

		return subjectRepository.save(pSubject);
	}

	/**
	 * This method is used to get Subject Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public Subject getSubject(Integer subjectId) {

		return subjectRepository.findById(subjectId).get();
	}

	/**
	 * This method is used to update Subject Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public Subject updateSubject(Subject pSubject) {

		return subjectRepository.save(pSubject);
	}

	/**
	 * This method is used to Delete Subject Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public String deleteSubject(Integer subjectId) {
		subjectRepository.deleteById(subjectId);
		return "Subject Deleted ";
	}

}
