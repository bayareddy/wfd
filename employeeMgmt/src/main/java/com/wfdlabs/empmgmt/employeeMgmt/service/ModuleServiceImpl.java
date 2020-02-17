package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Module;
import com.wfdlabs.empmgmt.employeeMgmt.repository.ModuleRepository;
import com.wfdlabs.empmgmt.employeeMgmt.service.ModuleService;
import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {
	@Autowired
	private ModuleRepository moduleRepository;

	@Override
	public Module createModule(Module module) {
		System.out.println("Save module");
		return moduleRepository.save(module);
	}

	@Override
	public Module getModule(Integer moduleTypeId) {
		return moduleRepository.findById(moduleTypeId).get();
	}

	@Override
	public List<Module> getAllModule() {
		return moduleRepository.findAll();
	}

	@Override
	public String deleteModule(Integer ModuleTypeID) {
		System.out.println("delete module record ");
		moduleRepository.deleteById(ModuleTypeID);
		return "deleted record successfully";
	}

	@Override
	public Module updateModule(Module module) {
		System.out.println("update and save module record");
		return moduleRepository.save(module);
	}
}
