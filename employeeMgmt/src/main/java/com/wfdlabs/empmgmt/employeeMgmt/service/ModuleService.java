package com.wfdlabs.empmgmt.employeeMgmt.service;

import java.util.List;
import com.wfdlabs.empmgmt.employeeMgmt.entity.Module;

public interface ModuleService {
	public Module createModule(Module module);

	public Module getModule(Integer moduleTypeId);

	public List<Module> getAllModule();

	public String deleteModule(Integer moduleTypeId);

	public Module updateModule(Module module);
}
