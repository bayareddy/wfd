/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.BankDetails;

/**
 * @author DELL
 *
 */
public interface BankDetailsService {

	BankDetails createBankDetails(BankDetails pBankDetails);

	BankDetails getBankDetails(Integer id);

	BankDetails updateBankDetails(BankDetails pBankDetails);

	String deleteBankDetails(Integer id);

}
