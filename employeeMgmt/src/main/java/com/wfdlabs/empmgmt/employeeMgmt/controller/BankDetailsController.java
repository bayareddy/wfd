package com.wfdlabs.empmgmt.employeeMgmt.controller;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wfdlabs.empmgmt.employeeMgmt.entity.BankDetails;
import com.wfdlabs.empmgmt.employeeMgmt.service.BankDetailsService;

@RequestMapping("/bankDetails")
@RestController
public class BankDetailsController {
	@Autowired
	BankDetailsService bankDetailsService;

	/**
	 * This method is used to create BankDetails
	 * 
	 * @param pBankDetails
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST)
	public BankDetails createBankDetails(@RequestBody BankDetails pBankDetails) {
		return bankDetailsService.createBankDetails(pBankDetails);

	}

	/**
	 * This method is used to get the bankDetails using id
	 * 
	 * @param id
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BankDetails> getBankDetails(@PathVariable Integer id) {
		BankDetails bankDetails = null;
		Boolean noSuchElement = false;
		try {
			bankDetails = bankDetailsService.getBankDetails(id);

		} catch (NoResultException e) {
			noSuchElement = true;
		}
		if (noSuchElement || bankDetails == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(bankDetails, HttpStatus.OK);

	}

	/**
	 * This method is used to update the BankDetails
	 * 
	 * @param pBankDetails
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.PUT)
	public BankDetails updateBankDetails(@RequestBody BankDetails pBankDetails) {
		return bankDetailsService.updateBankDetails(pBankDetails);

	}

	/**
	 * This method is used to delete bankDetails using id
	 * 
	 * @param id
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Integer id) {

		return bankDetailsService.deleteBankDetails(id);

	}

}
