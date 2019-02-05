package com.wfdlabs.empmgmt.employeeMgmt.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Project;
import com.wfdlabs.empmgmt.employeeMgmt.service.ProjectService;

@RestController
@RequestMapping("/Project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	/**
	 * This method is used to post project details
	 * 
	 * @param project
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Project> createProject(@RequestBody Project project) {
		System.out.println("Project:" + project);
		project.setUpdateDate(null);
		project= projectService.createProject(project);
		return new ResponseEntity<>(project,HttpStatus.OK);
	}

	/**
	 * This method is used to get particular project record based on Id
	 * 
	 * @param projectTypeId
	 * @return
	 */

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Project> getproject(@RequestParam Integer projectTypeId) {
		System.out.println("project:" + projectTypeId);
		Project project=null;
		boolean noElementFlag=false;
		try {
		  project= projectService.getproject(projectTypeId);
	}
		catch(NoSuchElementException nsee) {
			noElementFlag=true;
		}
		if(noElementFlag||project==null) {
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(project,HttpStatus.OK);
		}
			
		}

