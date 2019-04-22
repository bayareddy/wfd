/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Nithin
 *
 */
@Table(name="subject")
@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer subjectID;
	
	@Column
	public String subjectTitle;
	@Column
	public Integer subjectHeadId;
	
	@ManyToOne
	Subject subject;
	
	@OneToOne
	Address address;
	
	
	public Integer getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(Integer subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public Integer getSubjectHeadId() {
		return subjectHeadId;
	}
	public void setSubjectHeadId(Integer subjectHeadId) {
		this.subjectHeadId = subjectHeadId;
	}
	
	

}
