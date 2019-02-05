package com.wfdlabs.empmgmt.employeeMgmt.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmploymentHistory")
public class EmployementHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employementHistoryId;
	@Column
	private Integer employeeId;
	@Column
	private String emploeer;
	@Column
	private String agencyDetails;
	@Column
	private String location;
	@Column
	private String contactDetails;
	@Column
	private String employeeCode;
	@Column
	private Date employementStartDate;
	@Column
	private Date employementEndDate;
	@Column
	private String designation;

	@Override
	public String toString() {
		return "EmploymentHistory [employementHistoryId=" + employementHistoryId + ", employeeId=" + employeeId
				+ ", emploeer=" + emploeer + ", agencyDetails=" + agencyDetails + ", location=" + location
				+ ", contactDetails=" + contactDetails + ", employeeCode=" + employeeCode + ", employementStartDate="
				+ employementStartDate + ", employementEndDate=" + employementEndDate + ", designation=" + designation
				+ ", lastSalaryDrawn=" + lastSalaryDrawn + ", reasonForLeaving=" + reasonForLeaving
				+ ", reportingManager=" + reportingManager + ", hrManager=" + hrManager + "]";
	}

	public Integer getEmployementHistoryId() {
		return employementHistoryId;
	}

	public void setEmployementHistoryId(Integer employementHistoryId) {
		this.employementHistoryId = employementHistoryId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmploeer() {
		return emploeer;
	}

	public void setEmploeer(String emploeer) {
		this.emploeer = emploeer;
	}

	public String getAgencyDetails() {
		return agencyDetails;
	}

	public void setAgencyDetails(String agencyDetails) {
		this.agencyDetails = agencyDetails;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Date getEmployementStartDate() {
		return employementStartDate;
	}

	public void setEmployementStartDate(Date employementStartDate) {
		this.employementStartDate = employementStartDate;
	}

	public Date getEmployementEndDate() {
		return employementEndDate;
	}

	public void setEmployementEndDate(Date employementEndDate) {
		this.employementEndDate = employementEndDate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getLastSalaryDrawn() {
		return lastSalaryDrawn;
	}

	public void setLastSalaryDrawn(Integer lastSalaryDrawn) {
		this.lastSalaryDrawn = lastSalaryDrawn;
	}

	public String getReasonForLeaving() {
		return reasonForLeaving;
	}

	public void setReasonForLeaving(String reasonForLeaving) {
		this.reasonForLeaving = reasonForLeaving;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public String getHrManager() {
		return hrManager;
	}

	public void setHrManager(String hrManager) {
		this.hrManager = hrManager;
	}

	@Column
	private Integer lastSalaryDrawn;
	@Column
	private String reasonForLeaving;
	@Column
	private String reportingManager;
	@Column
	private String hrManager;

}


