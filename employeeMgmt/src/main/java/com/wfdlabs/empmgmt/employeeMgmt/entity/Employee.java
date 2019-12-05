/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author HP-PC
 *
 */
@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	@Column
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private Date startDate;
	@Column
	private String positionTitle;
	@Column
	private Integer departmentId;
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
	private Date joinDate;
    @Column
    private String pancard;
    @Column
    private Integer pf_No ;
    @Column
    private Integer eSI_no; 
    @Column
    private Integer Pension_no;
    @Column
    private String bank_name;
    @Column
    private Integer bank_Ac_no;
    

	public Integer getPf_No() {
		return pf_No;
	}


	public void setPf_No(Integer pf_No) {
		this.pf_No = pf_No;
	}


	public Integer geteSI_no() {
		return eSI_no;
	}

	public void seteSI_no(Integer eSI_no) {
		this.eSI_no = eSI_no;
	}

	
	public Integer getPension_no() {
		return Pension_no;
	}


	public void setPension_no(Integer pension_no) {
		Pension_no = pension_no;
	}

	
	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public Integer getBank_Ac_no() {
		return bank_Ac_no;
	}

	
	public void setBank_Ac_no(Integer bank_Ac_no) {
		this.bank_Ac_no = bank_Ac_no;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	@Column
	private String bankDetails;
	@Column
	private String peramanentAddress;
	@Column
	private String currentAddress;
	@Column
	private Date createDate;
	@Column
	private Date updateDate;
	
	/*@OneToOne
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}*/

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
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

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}

	public String getPeramanentAddress() {
		return peramanentAddress;
	}

	public void setPeramanentAddress(String peramanentAddress) {
		this.peramanentAddress = peramanentAddress;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", startDate=" + startDate + ", positionTitle=" + positionTitle
				+ ", departmentId=" + departmentId + ", dateofBirth=" + dateofBirth + ", gender=" + gender
				+ ", primaryMailId=" + primaryMailId + ", secondaryMailId=" + secondaryMailId + ", mobileNumber="
				+ mobileNumber + ", joinDate=" + joinDate + ", pancard=" + pancard + ", bankDetails=" + bankDetails
				+ ", peramanentAddress=" + peramanentAddress + ", currentAddress=" + currentAddress + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
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
}
