/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.wfdlabs.empmgmt.employeeMgmt.entity.User;
import com.wfdlabs.empmgmt.employeeMgmt.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	/**
	 * This method is used to create User details
	 * @param pUser
	 * @return
	 */
	@Override
	public User createUser(@RequestBody User pUser) {
		return userRepository.save(pUser);
	}
	/**
	 * This method is used to get the User details
	 * @param userId
	 * @return
	 */

	@Override
	public User getUser(@PathVariable Integer userId) {
		return userRepository.findById(userId).get();
	}
	/**
	 * This method is used to update the User details
	 * @param pUser
	 * @return
	 */

	@Override
	public User updateUser(@RequestBody User pUser) {
		return userRepository.save(pUser);
	}
	/**
	 * This method is used to delete the User details
	 * @param userId
	 * @return
	 */

	@Override
	public String deleteUser(@PathVariable Integer userId) {
		userRepository.deleteById(userId);
		return userId + "Delete Successfully";
	}

}
