/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 
 *
 */
@Entity
@Table(name="BankDetails")
public class BankDetails extends BaseEntity{
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Integer getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(Integer ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Column
	private String bankName;
	@Column
	private Integer ifscCode;
	@Column
	private Integer accountNumber;

	public Integer getPfNo() {
		return pfNo;
	}

	public void setPfNo(Integer pfNo) {
		this.pfNo = pfNo;
	}

	public Integer getEsiNo() {
		return esiNo;
	}

	public void setEsiNo(Integer esiNo) {
		this.esiNo = esiNo;
	}

	@Column
	private Integer pfNo;
	@Column
	private Integer esiNo;

}
