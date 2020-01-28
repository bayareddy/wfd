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
@Table(name = "candidate")
public class Candidate extends Person {
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getPositionTitle() {
		return positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPrimaryMailId() {
		return primaryMailId;
	}

	public void setPrimaryMailId(String primaryMailId) {
		this.primaryMailId = primaryMailId;
	}

	public String getSecondaryMailId() {
		return secondaryMailId;
	}

	public void setSecondaryMailId(String secondaryMailId) {
		this.secondaryMailId = secondaryMailId;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getPfNo() {
		return pfNo;
	}

	public void setPfNo(String pfNo) {
		this.pfNo = pfNo;
	}

	public String getEsiNo() {
		return esiNo;
	}

	public void setEsiNo(String esiNo) {
		this.esiNo = esiNo;
	}

	public String getPensionNo() {
		return pensionNo;
	}

	public void setPensionNo(String pensionNo) {
		this.pensionNo = pensionNo;
	}

	@Column
	private String password;
	@Column
	private Date startDate;
	@Column
	private String positionTitle;

	@Column
	private Date dateofBirth;
	@Column
	private String gender;
	@Column
	private String primaryMailId;
	@Column
	private String secondaryMailId;
	@Column
	private Integer mobileNumber;

	@Column
	private String pancard;

	@Column
	private Date createDate;
	@Column
	private Date updateDate;
	@Column
	private String pfNo;
	@Column
	private String esiNo;
	@Column
	private String pensionNo;

}
