/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Holiday;
import com.wfdlabs.empmgmt.employeeMgmt.repository.HolidayRepository;

/**
 * @author syam prasad
 *
 */
@Service
public class HolidayServiceImpl implements HolidayService {
	@Autowired
	HolidayRepository holidayRepository;

	/**
	 * This method is used to create holiday details
	 * 
	 */
	@Override
	public Holiday create(Holiday pHoliday) {
		return holidayRepository.save(pHoliday);
	}

	/**
	 * This method is used to get the holiday details
	 * 
	 */
	@Override
	public Holiday get(Integer id) {
		return holidayRepository.findById(id).get();
	}

	/**
	 * This method is used to update holiday details
	 * 
	 */

	@Override
	public Holiday update(Holiday pHoliday) {
		return holidayRepository.save(pHoliday);
	}

	/**
	 * This method is used to get the holiday details
	 * 
	 */
	@Override
	public String delete(Integer id) {
		holidayRepository.deleteById(id);
		return id + " Delete Successfully";
	}

}
