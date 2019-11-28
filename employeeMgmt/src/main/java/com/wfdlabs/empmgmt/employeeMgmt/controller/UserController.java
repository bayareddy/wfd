/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.controller;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wfdlabs.empmgmt.employeeMgmt.entity.User;
import com.wfdlabs.empmgmt.employeeMgmt.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	UserService userService;
	/**
	 * This method is used to create the User details
	 * @param pUser
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.POST)
	public User createUser(@RequestBody User pUser) {
		return userService.createUser(pUser);
		
	}
	/**
	 * This method is used to get the User details by using userId
	 * @param userId
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable Integer userId){
		User user = null;
		Boolean noSuchElement=false;
		try {
			user= userService.getUser(userId);
		}catch (NoResultException nsee) {
			noSuchElement = true;
		}
		if(noSuchElement || user==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);	
	}
	/**
	 * This method is used to update the User details 
	 * @param pUser
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(method = RequestMethod.PUT)
	public User updateUser(@RequestBody User pUser) {
		return userService.updateUser(pUser);
		
	}
	/**
	 * This is method is used to delete the User details
	 * @param userId
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value ="/{userId}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Integer userId) {
		return userService.deleteUser(userId);
		
	}

}
