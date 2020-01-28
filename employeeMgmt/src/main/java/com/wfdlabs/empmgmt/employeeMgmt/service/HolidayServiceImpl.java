/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Holiday;
import com.wfdlabs.empmgmt.employeeMgmt.repository.HolidayRepositiory;

/**
 * @author DELL
 *
 */
@Service
public class HolidayServiceImpl  implements HolidayService{

	@Autowired
	HolidayRepositiory holidayRepositiory;
	
	@Override
	public Holiday create(Holiday pHoliday) {
		return holidayRepositiory.save(pHoliday);
	}

	@Override
	public Holiday get(Integer id) {
		return holidayRepositiory.findById(id).get();
	}

	@Override
	public Holiday update(Holiday pHoliday) {
		return holidayRepositiory.save(pHoliday);
	}

	@Override
	public String delete(Integer id) {
		holidayRepositiory.deleteById(id);
		return id + "Delete Record Successfully";
	}

}
