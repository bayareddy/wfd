package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Project;

public interface ProjectService {
	public Project createProject(Project project);

	public Project getproject(Integer projectTypeId);
}
