/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Nithin
 *
 */
@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer studentId;
	@Column
	public String fistName;
	@Column
	public String lastName;
	@Column
	public String DOB;
	@Column
	public String sex;
	@Column
	public String mailId;
	@Column
	public String joiningDate; 
	@Column
	public String fatherName;
	@Column
	public String motherName;
	@Column
	public String primaryMobileNumber;
	@Column
	public String secondayMobileNumber;
	@Column
	public String parentOccupstion;
	
	
//	@ManyToOne
	//Attendence attendence;
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getPrimaryMobileNumber() {
		return primaryMobileNumber;
	}
	public void setPrimaryMobileNumber(String primaryMobileNumber) {
		this.primaryMobileNumber = primaryMobileNumber;
	}
	public String getSecondayMobileNumber() {
		return secondayMobileNumber;
	}
	public void setSecondayMobileNumber(String secondayMobileNumber) {
		this.secondayMobileNumber = secondayMobileNumber;
	}
	public String getParentOccupstion() {
		return parentOccupstion;
	}
	public void setParentOccupstion(String parentOccupstion) {
		this.parentOccupstion = parentOccupstion;
	}
	
}
