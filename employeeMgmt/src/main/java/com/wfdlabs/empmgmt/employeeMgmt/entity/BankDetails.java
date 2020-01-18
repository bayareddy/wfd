package com.wfdlabs.empmgmt.employeeMgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author syam prasad
 *
 */
@Entity
@Table(name = "bankDetails")
public class BankDetails extends BaseEntity {

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

	
	
}
