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
@Table(name="marks")
public class Marks {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public int marks_id;
	@Column
	public int student_id;
	@Column
	public int subject_id;
	@Column
	public int examtype_id;
	@Column
	public int marks;
	public int getMarks_id() {
		return marks_id;
	}
	public void setMarks_id(int marks_id) {
		this.marks_id = marks_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public int getExamtype_id() {
		return examtype_id;
	}
	public void setExamtype_id(int examtype_id) {
		this.examtype_id = examtype_id;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Column
	public Date date;

}
