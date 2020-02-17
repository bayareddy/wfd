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
	@Column
	private Integer employee_provident_fund;
	@Column
	private Integer employee_ESI_Contribution;
	@Column
	private Integer professional_Tax;
	
	

	public Integer getEmployee_provident_fund() {
		return employee_provident_fund;
	}
	public void setEmployee_provident_fund(Integer employee_provident_fund) {
		this.employee_provident_fund = employee_provident_fund;
	}
	public Integer getEmployee_ESI_Contribution() {
		return employee_ESI_Contribution;
	}
	public void setEmployee_ESI_Contribution(Integer employee_ESI_Contribution) {
		this.employee_ESI_Contribution = employee_ESI_Contribution;
	}
	public Integer getProfessional_Tax() {
		return professional_Tax;
	}
	public void setProfessional_Tax(Integer professional_Tax) {
		this.professional_Tax = professional_Tax;
	}
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




