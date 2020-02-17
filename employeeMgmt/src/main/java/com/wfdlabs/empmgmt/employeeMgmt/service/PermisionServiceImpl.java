package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wfdlabs.empmgmt.employeeMgmt.entity.Permision;
import com.wfdlabs.empmgmt.employeeMgmt.repository.PermisionRepository;
import com.wfdlabs.empmgmt.employeeMgmt.service.PermisionService;
import java.util.List;

@Service
public class PermisionServiceImpl implements PermisionService {
	@Autowired
	private PermisionRepository permisionRepository;

	@Override
	public Permision createPermision(Permision permision) {
		System.out.println("Save permision");
		return permisionRepository.save(permision);
	}

	@Override
	public Permision getPermision(Integer permisionTypeId) {
		return permisionRepository.findById(permisionTypeId).get();
	}

	@Override
	public String deletePermision(Integer permisionTypeId) {
		System.out.println("delete permision record ");
		permisionRepository.deleteById(permisionTypeId);
		return "delete record successfully";
	}

	@Override
	public List<Permision> getAllPermision() {
		return permisionRepository.findAll();
	}

	@Override
	public Permision updatePermision(Permision permision) {
		System.out.println("update and save permision record");
		return permisionRepository.save(permision);
	}
}
