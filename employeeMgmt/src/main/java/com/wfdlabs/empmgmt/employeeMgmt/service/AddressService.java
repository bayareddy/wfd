package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Address;

public interface AddressService {

	Address create(Address pAddress);

	Address update(Address pAddress);

	String delete(Integer addressId);

	Address get(Integer addressId);

}
