/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Address;
import com.wfdlabs.empmgmt.employeeMgmt.repository.AddressRepositiory;

/**
 * @author DELL
 *
 */
@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressRepositiory addressRepositiory;

	@Override
	public Address create(Address pAddress) {

		return addressRepositiory.save(pAddress);
	}

	@Override
	public Address update(Address pAddress) {
		return addressRepositiory.save(pAddress);
	}

	@Override
	public String delete(Integer addressId) {
		addressRepositiory.deleteById(addressId);
		return addressId + "Delete Record Succesfully";
	}

	@Override
	public Address get(Integer addressId) {
		
		return addressRepositiory.findById(addressId).get();
	}

}
