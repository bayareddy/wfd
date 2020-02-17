/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.User;

public interface UserService {
	/**
	 * This method is used to create the User details
	 * @param pUser
	 * @return
	 */

	User createUser(User pUser);
	/**
	 * This method is used to get the User details by using userId
	 * @param userId
	 * @return
	 */

	User getUser(Integer userId);
	/**
	 * This method is used to update the user details
	 * @param pUser
	 * @return
	 */

	User updateUser(User pUser);
	/**
	 * This method is used to delete the User details by using userId
	 * @param userId
	 * @return
	 */

	String deleteUser(Integer userId);

}
