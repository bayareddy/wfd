package com.wfdlabs.empmgmt.employeeMgmt.service;
import java.util.List;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Permision;
public interface PermisionService {
	public Permision createPermision(Permision permision);

	public Permision getPermision(Integer permisionTypeId);

	public String deletePermision(Integer PermisionTypeId);

	public List<Permision> getAllPermision();

	public Permision updatePermision(Permision permision);
}
