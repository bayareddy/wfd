package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wfdlabs.empmgmt.employeeMgmt.entity.Project;
import com.wfdlabs.empmgmt.employeeMgmt.repository.ProjectRepository;
import com.wfdlabs.empmgmt.employeeMgmt.service.ProjectService;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;

	/**
	 * This method is used to create project details
	 * 
	 * @param project
	 * @return
	 */
	@Override
	public Project createProject(Project project) {
		System.out.println("Save project");
		return projectRepository.save(project);
	}

	/**
	 * This method is used to get particular project record based on Id
	 * 
	 * @param projectTypeId
	 * @return
	 */

	@Override
	public Project getproject(Integer projectTypeId) {
		return projectRepository.findById(projectTypeId).get();
	}

}
