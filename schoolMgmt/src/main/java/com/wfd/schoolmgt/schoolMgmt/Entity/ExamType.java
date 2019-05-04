/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;


@Entity
@Table(name = "examtype")
public class ExamType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	@Column
	public String examType;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="examTypeId")
	@OrderColumn(name="table")
	List<Marks> marks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String examType) {
		this.examType = examType;
	}
	public List<Marks> getMarks() {
		return marks;
	}
	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}	
	
	
		
}
