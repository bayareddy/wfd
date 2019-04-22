/**
 * 
 */
package com.wfd.schoolmgt.schoolMgmt.Service;

import com.wfd.schoolmgt.schoolMgmt.Entity.Address;

/**
 * @author Nithin
 *
 */
public interface AddressService {

	/**
	 * This method is used to create AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	Address createAddress(Address pAddress);

	/**
	 * This method is used to get AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	Address getAddress(Integer addressId);

	/**
	 * This method is used to update AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	Address updateAddress(Address pAddress);

	/**
	 * This method is used to Delete AddressDetails
	 * 
	 * @param pAddress
	 * @return
	 */

	String deleteAddress(Integer addressId);

}
