package com.wfdlabs.empmgmt.employeeMgmt.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="LeaveStatus")
public class LeaveStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer leaveStatusId;
	@Column
	private String leaveStatusName;
	@Column
	private Date createdate;
	@Column
	private Date updateDate;
	public Integer getLeaveStatusId() {
		return leaveStatusId;
	}
	public void setLeaveStatusId(Integer leaveStatusId) {
		this.leaveStatusId = leaveStatusId;
	}
	public String getLeaveStatusName() {
		return leaveStatusName;
	}
	public void setLeaveStatusName(String leaveStatusName) {
		this.leaveStatusName = leaveStatusName;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "LeaveStatus [leaveStatusId=" + leaveStatusId + ", leaveStatusName=" + leaveStatusName + ", createdate="
				+ createdate + ", updateDate=" + updateDate + "]";
	}
	

}

