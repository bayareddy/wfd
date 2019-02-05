package com.wfdlabs.empmgmt.employeeMgmt.entity;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="SalaryOffered")
public class SalaryOffered {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer salaryOfferedId;
	@Column
	private Integer basic;
	@Column
	private Integer houseRentAllowance;
	@Column
	private Integer specialAllowance;
	@Column
	private Integer conveyanceAllowance;
	@Column
	private Integer medicalAllowance;
	@Column
	private Integer companyContributionToPf;
	@Column
	private Integer IncentiveAsPerPerformancePay;
	@Column
	private Integer payOnMonthOryear;
	public Integer getSalaryOfferedId() {
		return salaryOfferedId;
	}
	public void setSalaryOfferedId(Integer salaryOfferedId) {
		this.salaryOfferedId = salaryOfferedId;
	}
	public Integer getBasic() {
		return basic;
	}
	public void setBasic(Integer basic) {
		this.basic = basic;
	}
	public Integer getHouseRentAllowance() {
		return houseRentAllowance;
	}
	public void setHouseRentAllowance(Integer houseRentAllowance) {
		this.houseRentAllowance = houseRentAllowance;
	}
	public Integer getSpecialAllowance() {
		return specialAllowance;
	}
	public void setSpecialAllowance(Integer specialAllowance) {
		this.specialAllowance = specialAllowance;
	}
	public Integer getConveyanceAllowance() {
		return conveyanceAllowance;
	}
	public void setConveyanceAllowance(Integer conveyanceAllowance) {
		this.conveyanceAllowance = conveyanceAllowance;
	}
	public Integer getMedicalAllowance() {
		return medicalAllowance;
	}
	public void setMedicalAllowance(Integer medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}
	public Integer getCompanyContributionToPf() {
		return companyContributionToPf;
	}
	public void setCompanyContributionToPf(Integer companyContributionToPf) {
		this.companyContributionToPf = companyContributionToPf;
	}
	public Integer getIncentiveAsPerPerformancePay() {
		return IncentiveAsPerPerformancePay;
	}
	public void setIncentiveAsPerPerformancePay(Integer incentiveAsPerPerformancePay) {
		IncentiveAsPerPerformancePay = incentiveAsPerPerformancePay;
	}
	public Integer getPayOnMonthOryear() {
		return payOnMonthOryear;
	}
	public void setPayOnMonthOryear(Integer payOnMonthOryear) {
		this.payOnMonthOryear = payOnMonthOryear;
	}
	@Override
	public String toString() {
		return "SalaryOffered [salaryOfferedId=" + salaryOfferedId + ", basic=" + basic + ", houseRentAllowance="
				+ houseRentAllowance + ", specialAllowance=" + specialAllowance + ", conveyanceAllowance="
				+ conveyanceAllowance + ", medicalAllowance=" + medicalAllowance + ", companyContributionToPf="
				+ companyContributionToPf + ", IncentiveAsPerPerformancePay=" + IncentiveAsPerPerformancePay
				+ ", payOnMonthOryear=" + payOnMonthOryear + "]";
	}

}




