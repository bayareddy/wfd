package com.wfdlabs.empmgmt.employeeMgmt.entity;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "permision")

public class Permision {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer PermisionId;
	@Column
	private String PermisionName;
	@Column
	private Date createDate;
	@Column
	private Date updateDate;
	@ManyToOne
	private Module moduleId;
	@ManyToOne
	private Role roleId;

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

	public Module getModuleId() {
		return moduleId;
	}

	public void setModuleId(Module moduleId) {
		this.moduleId = moduleId;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public Integer getPermisionId() {
		return PermisionId;
	}

	public void setPermisionId(Integer permisionId) {
		PermisionId = permisionId;
	}

	public String getPermisionName() {
		return PermisionName;
	}

	public void setPermisionName(String permisionName) {
		PermisionName = permisionName;
	}

	@Override
	public String toString() {
		return "Permision [PermisionId=" + PermisionId + ", PermisionName=" + PermisionName + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", moduleId=" + moduleId + ", roleId=" + roleId + "]";
	}

}
