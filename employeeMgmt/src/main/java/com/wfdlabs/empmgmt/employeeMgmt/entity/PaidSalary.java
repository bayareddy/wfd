package com.wfdlabs.empmgmt.employeeMgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "paidSalary")
@Entity
public class PaidSalary extends BaseEntity{

	
	@Column
	private String month;
	@Column
	private Integer basicSalary;
	@Column
	private Integer houseRentAllowance;
	@Column
	private Integer adjustmentHouseRentAllowance;
	@Column
	private Integer conveyanceAllowance;
	@Column
	private Integer adjustmentConveyanceAllowance;
	@Column
	private Integer medicalAllowance;
	@Column
	private Integer adjustmentMedicalAllowance;
	@Column
	private Integer providentFund;
	@Column
	private Integer adjustmentProvidentFund;
	@Column
	private Integer esiContribution;
	@Column
	private Integer professionalTax;
	@Column
	private Integer adjustmentProfessionalTax;
	@Column
	private Integer totalPayments;
	@Column
	private Integer totalDeductions;
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(Integer basicSalary) {
		this.basicSalary = basicSalary;
	}
	public Integer getHouseRentAllowance() {
		return houseRentAllowance;
	}
	public void setHouseRentAllowance(Integer houseRentAllowance) {
		this.houseRentAllowance = houseRentAllowance;
	}
	public Integer getAdjustmentHouseRentAllowance() {
		return adjustmentHouseRentAllowance;
	}
	public void setAdjustmentHouseRentAllowance(Integer adjustmentHouseRentAllowance) {
		this.adjustmentHouseRentAllowance = adjustmentHouseRentAllowance;
	}
	public Integer getConveyanceAllowance() {
		return conveyanceAllowance;
	}
	public void setConveyanceAllowance(Integer conveyanceAllowance) {
		this.conveyanceAllowance = conveyanceAllowance;
	}
	public Integer getAdjustmentConveyanceAllowance() {
		return adjustmentConveyanceAllowance;
	}
	public void setAdjustmentConveyanceAllowance(Integer adjustmentConveyanceAllowance) {
		this.adjustmentConveyanceAllowance = adjustmentConveyanceAllowance;
	}
	public Integer getMedicalAllowance() {
		return medicalAllowance;
	}
	public void setMedicalAllowance(Integer medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}
	public Integer getAdjustmentMedicalAllowance() {
		return adjustmentMedicalAllowance;
	}
	public void setAdjustmentMedicalAllowance(Integer adjustmentMedicalAllowance) {
		this.adjustmentMedicalAllowance = adjustmentMedicalAllowance;
	}
	public Integer getProvidentFund() {
		return providentFund;
	}
	public void setProvidentFund(Integer providentFund) {
		this.providentFund = providentFund;
	}
	public Integer getAdjustmentProvidentFund() {
		return adjustmentProvidentFund;
	}
	public void setAdjustmentProvidentFund(Integer adjustmentProvidentFund) {
		this.adjustmentProvidentFund = adjustmentProvidentFund;
	}
	public Integer getEsiContribution() {
		return esiContribution;
	}
	public void setEsiContribution(Integer esiContribution) {
		this.esiContribution = esiContribution;
	}
	public Integer getProfessionalTax() {
		return professionalTax;
	}
	public void setProfessionalTax(Integer professionalTax) {
		this.professionalTax = professionalTax;
	}
	public Integer getAdjustmentProfessionalTax() {
		return adjustmentProfessionalTax;
	}
	public void setAdjustmentProfessionalTax(Integer adjustmentProfessionalTax) {
		this.adjustmentProfessionalTax = adjustmentProfessionalTax;
	}
	public Integer getTotalPayments() {
		return totalPayments;
	}
	public void setTotalPayments(Integer totalPayments) {
		this.totalPayments = totalPayments;
	}
	public Integer getTotalDeductions() {
		return totalDeductions;
	}
	public void setTotalDeductions(Integer totalDeductions) {
		this.totalDeductions = totalDeductions;
	}


}
