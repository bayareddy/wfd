package com.wfdlabs.empmgmt.employeeMgmt.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="academicBackGround")
public class AcademicBackGround {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer academicBackGroundId;
	@Column
	private String institute;
	@Column
	private String affilicatedUniversity;
	@Column
	private String  contactDetails;
	@Column
	private String qualification;
	@Column
	private String specialization;
	@Column
	private Date courseStartDate;
	@Column
	private Date courseEndDate;
	@Column
	private String registrationNumber;
	@Column
	private Integer marksObtained;
	@Column
	private String courseStatus;
	public Integer getAcademicBackGroundId() {
		return academicBackGroundId;
	}
	public void setAcademicBackGroundId(Integer academicBackGroundId) {
		this.academicBackGroundId = academicBackGroundId;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getAffilicatedUniversity() {
		return affilicatedUniversity;
	}
	public void setAffilicatedUniversity(String affilicatedUniversity) {
		this.affilicatedUniversity = affilicatedUniversity;
	}
	public String getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Date getCourseStartDate() {
		return courseStartDate;
	}
	public void setCourseStartDate(Date courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	public Date getCourseEndDate() {
		return courseEndDate;
	}
	public void setCourseEndDate(Date courseEndDate) {
		this.courseEndDate = courseEndDate;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public Integer getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(Integer marksObtained) {
		this.marksObtained = marksObtained;
	}
	public String getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}
	@Override
	public String toString() {
		return "AcademicBackGround [academicBackGroundId=" + academicBackGroundId + ", institute=" + institute
				+ ", affilicatedUniversity=" + affilicatedUniversity + ", contactDetails=" + contactDetails
				+ ", qualification=" + qualification + ", specialization=" + specialization + ", courseStartDate="
				+ courseStartDate + ", courseEndDate=" + courseEndDate + ", registrationNumber=" + registrationNumber
				+ ", marksObtained=" + marksObtained + ", courseStatus=" + courseStatus + "]";
	}
	
	
	

}
