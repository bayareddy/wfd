package com.wfdlabs.empmgmt.employeeMgmt.entity;

import javax.persistence.*;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Client;

import java.util.Date;

@Entity
@Table(name = "Project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer projectId;
	@Column
	private String projectName;
	@Column
	private Integer projectNumber;
	@Column
	private String location;
	@ManyToOne
	private Client client;
	@Column
	private Date createDate;
	@Column
	private Date updateDate;

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectNumber=" + projectNumber
				+ ", location=" + location + ", client=" + client + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(Integer projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

}
