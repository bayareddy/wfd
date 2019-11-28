package com.wfdlabs.empmgmt.employeeMgmt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Permision;
import com.wfdlabs.empmgmt.employeeMgmt.service.PermisionService;
import java.util.List;

@RestController
@RequestMapping("/Permision")
public class PermisionController {
	@Autowired
	private PermisionService permisionService;

	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.POST)
	public Permision createPermision(@RequestBody Permision permision) {
		System.out.println("Permision:" + permision);
		return permisionService.createPermision(permision);
	}
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.GET)
	public Permision getPermision(@RequestParam Integer permisionTypeId) {
		System.out.println("Permision:" + permisionTypeId);
		return permisionService.getPermision(permisionTypeId);
	}
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public List<Permision> getAllPermision() {
		return permisionService.getAllPermision();
	}
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.DELETE)
	public String deletepermision(@RequestParam Integer permisionTypeId) {
		System.out.println("PermisionTypeId:" + permisionTypeId);
		permisionService.deletePermision(permisionTypeId);
		return "delete record successfully";
	}
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.PUT)
	public Permision updatePermision(@RequestBody Permision permision) {
		System.out.println("Permision:" + permision);
		return permisionService.updatePermision(permision);

	}

}
