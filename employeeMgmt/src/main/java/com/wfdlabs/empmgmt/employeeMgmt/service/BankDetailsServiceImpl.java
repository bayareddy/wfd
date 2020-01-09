package com.wfdlabs.empmgmt.employeeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.BankDetails;
import com.wfdlabs.empmgmt.employeeMgmt.repository.BankDetailsRepository;

@Service
public class BankDetailsServiceImpl implements BankDetailsService {
	@Autowired
	BankDetailsRepository bankDetailsRepository;

	/**
	 * This method is used to create bankDetails
	 * 
	 */
	@Override
	public BankDetails createBankDetails(BankDetails pBankDetails) {
		return bankDetailsRepository.save(pBankDetails);
	}

	/**
	 * This method is used to get the bankDetails using id
	 * 
	 */
	@Override
	public BankDetails getBankDetails(Integer id) {
		return bankDetailsRepository.findById(id).get();
	}

	/**
	 * This method is used to update the bankDetails
	 * 
	 */
	@Override
	public BankDetails updateBankDetails(BankDetails pBankDetails) {
		return bankDetailsRepository.save(pBankDetails);
	}

	/**
	 * This method is used to delete bankDetails using id
	 * 
	 */
	@Override
	public String deleteBankDetails(Integer id) {
		bankDetailsRepository.deleteById(id);
		return id + " Delete Successfully";
	}

}
