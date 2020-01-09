/**
 * 
 */
package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.BankDetails;
import com.wfdlabs.empmgmt.employeeMgmt.repository.BankDetailsRepositiory;

/**
 * @author DELL
 *
 */
@Service
public class BankDetailsServiceImpl implements BankDetailsService{
	@Autowired
	BankDetailsRepositiory bankDetailsRepositiory;

	@Override
	public BankDetails createBankDetails(BankDetails pBankDetails) {
		
		return bankDetailsRepositiory.save(pBankDetails);
	}

	@Override
	public BankDetails getBankDetails(Integer id) {
	
		return bankDetailsRepositiory.findById(id).get();
	}

	@Override
	public BankDetails updateBankDetails(BankDetails pBankDetails) {
		return bankDetailsRepositiory.save(pBankDetails);
	}

	@Override
	public String deleteBankDetails(Integer id) {
		bankDetailsRepositiory.deleteById(id);
		return id + "Record deleted Succesfully";
	}

}
