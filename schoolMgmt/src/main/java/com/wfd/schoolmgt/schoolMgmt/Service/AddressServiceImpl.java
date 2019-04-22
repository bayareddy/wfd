/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfd.schoolmgt.schoolMgmt.Entity.Address;
import com.wfd.schoolmgt.schoolMgmt.Repository.AddressRepository;

/**
 * @author Nithin
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
	public Address createAddress(Address pAddress) {

		return addressRepository.save(pAddress);
	}

	/**
	 * This method is used to get AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public Address getAddress(Integer addressId) {

		return addressRepository.findById(addressId).get();
	}

	/**
	 * This method is used to update AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public Address updateAddress(Address pAddress) {

		return addressRepository.save(pAddress);
	}

	/**
	 * This method is used to Delete AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	@Override
	public String deleteAddress(Integer addressId) {
		addressRepository.deleteById(addressId);
		return "Address Deleted";
	}

}
