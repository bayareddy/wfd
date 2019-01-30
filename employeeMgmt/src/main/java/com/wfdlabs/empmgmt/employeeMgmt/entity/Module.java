package com.wfdlabs.empmgmt.employeeMgmt.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Module")
public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer moduleId;
	@Column
	private String moduleName;
	@Column
	private Date createDate;
	@Column
	private Date updateDate;

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
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
		return "Module [moduleId=" + moduleId + ", moduleName=" + moduleName + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

}
