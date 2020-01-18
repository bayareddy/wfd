package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Address;

public interface AddressService {
	/**
	 * This method is used to create AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */
	Address create(Address pAddress);

	/**
	 * This is used to get the AddressDetails
	 * 
	 * @param addressId
	 * @return
	 */

	Address get(Integer addressId);

	/**
	 * This is used to update the AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	Address update(Address pAddress);

	/**
	 * This is used to delete the AddressDetails
	 * 
	 * @param addressId
	 * @return
	 */

	String delete(Integer addressId);

}
