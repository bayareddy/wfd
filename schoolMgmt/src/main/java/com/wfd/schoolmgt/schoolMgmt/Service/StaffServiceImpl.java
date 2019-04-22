/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfd.schoolmgt.schoolMgmt.Entity.Staff;
import com.wfd.schoolmgt.schoolMgmt.Repository.StaffRepository;

/**
 * @author Nithin
 *
 */
@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	StaffRepository staffRepository;

	/**
	 * This method is used to create Staff Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public Staff createStaff(Staff pStaff) {

		return staffRepository.save(pStaff);
	}

	/**
	 * This method is used to get Staff Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public Staff getStaff(Integer staffId) {

		return staffRepository.findById(staffId).get();
	}

	/**
	 * This method is used to update Staff Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public Staff updateStaff(Staff pStaff) {

		return staffRepository.save(pStaff);
	}

	/**
	 * This method is used to delete Staff Details
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public String deleteStaff(Integer staffId) {
		staffRepository.deleteById(staffId);
		return "Staff Data Deleted";
	}

}
