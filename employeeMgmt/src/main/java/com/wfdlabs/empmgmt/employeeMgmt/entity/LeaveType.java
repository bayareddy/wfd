package com.wfdlabs.empmgmt.employeeMgmt.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * This class is used to mapped with leavetype obj to leavetype relational data
 * @author neelima
 *
 */

@Entity
@Table(name="LeaveType")
public class LeaveType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="lid")
	private Integer leaveTypeId;
	@Column
	private String leaveTypeName;
	@Column
	private Date createDate;
	@Column
	private Date updateDate;
	public Integer getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	public String getLeaveTypeName() {
		return leaveTypeName;
	}
	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
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
		return "LeaveType [leaveTypeId=" + leaveTypeId + ", leaveTypeName=" + leaveTypeName + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}
	

}

