/**
 * 
 */

package com.wfd.schoolmgt.schoolMgmt.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timetable")
public class TimeTable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int timeTableId;
	@Column
	public int classId;
	@Column
	public Date classStartTime;
	@Column
	public Date classEndTime;
	public int getTimeTableId() {
		return timeTableId;
	}
	public void setTimeTableId(int timeTableId) {
		this.timeTableId = timeTableId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public Date getClassStartTime() {
		return classStartTime;
	}
	public void setClassStartTime(Date classStartTime) {
		this.classStartTime = classStartTime;
	}
	public Date getClassEndTime() {
		return classEndTime;
	}
	public void setClassEndTime(Date classEndTime) {
		this.classEndTime = classEndTime;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	@Column
	public int subjectId;
	@Column
	public int staffId;

}
