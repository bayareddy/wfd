/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "examtype")
public class ExamType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	@Column
	public String examType;
	
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
	
	
	
		
}
