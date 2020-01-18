/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Address;
import com.wfdlabs.empmgmt.employeeMgmt.repository.AddressRepository;

/**
 * @author syam prasad
 *
 */
@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressRepository addressRepository;

	/**
	 * This method is used to create AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public Address create(Address pAddress) {
		return addressRepository.save(pAddress);
	}

	/**
	 * This is used to get the AddressDetails
	 * 
	 * @param addressId
	 * @return
	 */

	@Override
	public Address get(Integer addressId) {
		return addressRepository.findById(addressId).get();
	}

	/**
	 * This is used to update the AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public Address update(Address pAddress) {
		return addressRepository.save(pAddress);
	}

	/**
	 * This is used to Delete the AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public String delete(Integer addressId) {
		addressRepository.deleteById(addressId);
		return "deleted record sucessfully";
	}

}
