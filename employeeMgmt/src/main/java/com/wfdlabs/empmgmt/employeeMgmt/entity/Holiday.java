/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author DELL
 *
 */
@Entity
@Table(name="holiday")
public class Holiday extends BaseEntity{
	@Column
	private Date holidayDate;
	/**
	 * @return the holidayDate
	 */
	public Date getHolidayDate() {
		return holidayDate;
	}
	/**
	 * @param holidayDate the holidayDate to set
	 */
	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}
	/**
	 * @return the holidayName
	 */
	public String getHolidayName() {
		return holidayName;
	}
	/**
	 * @param holidayName the holidayName to set
	 */
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}
	@Column
	private String holidayName;

}
