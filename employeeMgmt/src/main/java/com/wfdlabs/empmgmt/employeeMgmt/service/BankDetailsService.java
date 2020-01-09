package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.BankDetails;

public interface BankDetailsService {
	/**
	 * This method is used to create bankDetails
	 * 
	 * @param pBankDetails
	 * @return
	 */
	BankDetails createBankDetails(BankDetails pBankDetails);

	/**
	 * This method is used to get the bankDetails using id
	 * 
	 * @param id
	 * @return
	 */

	BankDetails getBankDetails(Integer id);

	/**
	 * This method is used to update the bankDetails
	 * 
	 * @param pBankDetails
	 * @return
	 */

	BankDetails updateBankDetails(BankDetails pBankDetails);

	/**
	 * This method is used to delete the bankDetails using id
	 * 
	 * @param id
	 * @return
	 */
	String deleteBankDetails(Integer id);

}
