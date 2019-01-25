package com.wfdlabs.empmgmt.employeeMgmt.entity;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="Salary")
public class Salary {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer salaryId;
@Column
private String salaryMonth;
@Column
private Date salaryDate;
@Column
private Date createDate;
@Column
private Date updateDate;
@ManyToOne
private Employee employee;
public Integer getSalaryId() {
	return salaryId;
}
public void setSalaryId(Integer salaryId) {
	this.salaryId = salaryId;
}
public String getSalaryMonth() {
	return salaryMonth;
}
public void setSalaryMonth(String salaryMonth) {
	this.salaryMonth = salaryMonth;
}
public Date getSalaryDate() {
	return salaryDate;
}
public void setSalaryDate(Date salaryDate) {
	this.salaryDate = salaryDate;
}
public Date getCreateDate() {
	return createDate;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
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
@Override
public String toString() {
	return "Salary [salaryId=" + salaryId + ", salaryMonth=" + salaryMonth + ", salaryDate=" + salaryDate
			+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", employee=" + employee + "]";
}

}
