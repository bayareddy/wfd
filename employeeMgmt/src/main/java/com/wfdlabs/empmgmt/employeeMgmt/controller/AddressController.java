/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Address;
import com.wfdlabs.empmgmt.employeeMgmt.service.AddressService;

/**
 * @author DELL
 *
 */
@RestController
@RequestMapping(value="/address")
public class AddressController {
	
	@Autowired
	AddressService addressSerrvice;

	/**
	 * This method is used to create AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	@RequestMapping(method = RequestMethod.POST)
	public Address create(@RequestBody Address pAddress) {
		return addressSerrvice.create(pAddress);
	}

	/**
	 * This method is used to get AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	@RequestMapping(value = "/{addressId}", method = RequestMethod.GET)
	public ResponseEntity<Address> get(@PathVariable Integer addressId) {
		Address address = null;
		Boolean noSuchElement = false;
		try {
			address = addressSerrvice.get(addressId);
		} catch (NoSuchElementException nsee) {
			noSuchElement = true;
		}
		if (noSuchElement || address == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(address, HttpStatus.OK);
	}

	/**
	 * This method is used to update AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Address update(@RequestBody Address pAddress) {
		return addressSerrvice.update(pAddress);
	}

	/**
	 * This method is used to Delete AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */
	@RequestMapping(value = "/{addressId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Integer addressId) {
		return addressSerrvice.delete(addressId);
	}

}
