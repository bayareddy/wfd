/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author DELL
 *
 */
@Entity
@Table(name="Department")
public class Department extends BaseEntity{
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	@Column
	private String name;
	@Column 
	private String description;

}
