package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Project;

public interface ProjectService {
	/**
	 * This method is used to create project details
	 * 
	 * @param project
	 * @return
	 */
	public Project createProject(Project project);

	/**
	 * This method is used to get particular project record based on Id
	 * 
	 * @param projectTypeId
	 * @return
	 */

	public Project getproject(Integer projectTypeId);
}
