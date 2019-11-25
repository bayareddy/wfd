package com.wfdlabs.empmgmt.employeeMgmt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Module;
import com.wfdlabs.empmgmt.employeeMgmt.service.ModuleService;
import java.util.List;

@RestController
@RequestMapping("/Module")
public class ModuleController {
	@Autowired
	private ModuleService moduleService;
	
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.POST)
	public Module createModule(@RequestBody Module Module) {
		System.out.println("Module:" + Module);
		Module.setUpdateDate(null);
		return moduleService.createModule(Module);
	}
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.GET)
	public Module getModule(@RequestParam Integer moduleTypeId) {
		System.out.println("Module:" + moduleTypeId);
		return moduleService.getModule(moduleTypeId);
	}
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public List<Module> getAllModule() {
		return moduleService.getAllModule();
	}
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteModule(@RequestParam Integer moduleTypeId) {
		System.out.println("clientTypeId:" + moduleTypeId);
		moduleService.deleteModule(moduleTypeId);
		return "delete record successfully";
	}
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.PUT)
	public Module updateModule(@RequestBody Module module) {
		System.out.println("Module:" + module);
		return moduleService.updateModule(module);

	}

}
