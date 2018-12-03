package com.wfdlabs.empmgmt.employeeMgmt.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="leave")
public class Leave {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer leaveId;
	
	@ManyToOne
	private LeaveStatus leaveStatus;
	
	@ManyToOne
	private LeaveType leaveType;
	
	@Column
	private Date leaveFrom;
	@Column
	private Date leaveTo;
	@Column
	private Date createDate;
	@Column
	private Date updateDate;
	
	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public  void setLeaveType(LeaveType leaveType) {
		this.leaveType=leaveType;
	}
	public Integer getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}
	public Date getLeaveFrom() {
		return leaveFrom;
	}
	public void setLeaveFrom(Date leaveFrom) {
		this.leaveFrom = leaveFrom;
	}
	public Date getLeaveTo() {
		return leaveTo;
	}
	public void setLeaveTo(Date leaveTo) {
		this.leaveTo = leaveTo;
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
	
	@Override
	public String toString() {
		return "Leave [leaveId=" + leaveId + ", leaveStatus=" + leaveStatus + ", leaveType=" + leaveType
				+ ", leaveFrom=" + leaveFrom + ", leaveTo=" + leaveTo + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}
	
	

}

