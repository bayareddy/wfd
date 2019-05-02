/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wfd.schoolmgt.schoolMgmt.Entity.Address;
import com.wfd.schoolmgt.schoolMgmt.Service.AddressService;

/**
 * @author Nithin
 *
 */
@RestController
@RequestMapping("/address")
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
	public Address createAddress(@RequestBody Address pAddress) {
		return addressSerrvice.createAddress(pAddress);
	}

	/**
	 * This method is used to get AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */
	
	@RequestMapping(value = "/{addressId}", method = RequestMethod.GET)
	public ResponseEntity<Address> getAddress(@PathVariable Integer addressId) {
		Address address=null;
		Boolean noSuchElement=false;
		try {
			address= addressSerrvice.getAddress(addressId);
		} catch (NoSuchElementException nsee) {
			noSuchElement=true;
		}
		if(noSuchElement || address==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(address,HttpStatus.OK);
	}

	/**
	 * This method is used to update AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Address updateAddress(@RequestBody Address pAddress) {
		return addressSerrvice.updateAddress(pAddress);
	}

	/**
	 * This method is used to Delete AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */
	@RequestMapping(value = "/{addressId}", method = RequestMethod.DELETE)
	public String deleteAddress(@PathVariable Integer addressId) {
		return addressSerrvice.deleteAddress(addressId);
	}

}
