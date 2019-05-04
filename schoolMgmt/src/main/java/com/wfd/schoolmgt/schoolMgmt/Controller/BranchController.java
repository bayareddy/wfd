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

import com.wfd.schoolmgt.schoolMgmt.Entity.Branch;
import com.wfd.schoolmgt.schoolMgmt.Service.BranchService;

/**
 * @author D
 *
 */
@RequestMapping("/Branch")
@RestController
public class BranchController {
	@Autowired
	public BranchService branchService;

	/**
	 * This method is used to post the Branch details
	 * 
	 * @param client
	 * @return
	 */

	@RequestMapping(method = RequestMethod.POST)
	public Branch createBranch(@RequestBody Branch pBranch) {
		return branchService.createBranch(pBranch);
	}

	/**
	 * This method is used to get particular Branch record based on BranchId
	 * 
	 * @param BranchId
	 * @return
	 */

	@RequestMapping(value = "/{BranchId}", method = RequestMethod.GET)
	public ResponseEntity<Branch> getBranch(@PathVariable Integer BranchId) {
		Branch branch=null;
		Boolean noSuchElement=false;
		try {
			branch= branchService.getBranch(BranchId);
		} catch (NoSuchElementException nsee) {
			noSuchElement=true;
		}
		if(noSuchElement || branch==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(branch,HttpStatus.OK);
	}

	/**
	 * This method is used to Update record based on BranchId
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Branch updateBranch(@RequestBody Branch pBranch) {
		return branchService.updateBranch(pBranch);
	}

	/**
	 * This method is used to delete record based on BranchId
	 * 
	 * @param BranchId
	 * @return
	 */

	@RequestMapping(value = "/{BranchId}", method = RequestMethod.DELETE)
	public String deleteBranch(@PathVariable Integer BranchId) {
		return branchService.deleteBranch(BranchId);
	}

}
