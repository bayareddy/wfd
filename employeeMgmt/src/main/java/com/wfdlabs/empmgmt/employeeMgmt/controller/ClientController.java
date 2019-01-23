package com.wfdlabs.empmgmt.employeeMgmt.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Client;
import com.wfdlabs.empmgmt.employeeMgmt.service.ClientService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/Client")
public class ClientController {
	@Autowired
	private ClientService clientService;

	/**
	 * This method is used to post the client details
	 * 
	 * @param client
	 * @return
	 */

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Client> createClient(@RequestBody Client client) {
		System.out.println("Client:" + client);
		client.setUpdateDate(null);
		client= clientService.createClient(client);
		return new ResponseEntity<>(client,HttpStatus.CREATED);
	}

	/**
	 * This method is used to get particular client record based on ClientTypeId
	 * 
	 * @param ClientTypeId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Client> getClient(@RequestParam Integer ClientTypeId) {
		System.out.println("Client:" + ClientTypeId);
		Client client=null;
		boolean noElementFlag=false;
		try {
			client=clientService.getClient(ClientTypeId);
		}
		catch(NoSuchElementException nsee) {
			noElementFlag=true;
		}
		if(noElementFlag||client==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	return new ResponseEntity<>(client,HttpStatus.OK);	
	}

	/**
	 * This method is used to get all the client details
	 * 
	 * @param
	 * @return
	 */

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public  ResponseEntity<List<Client>> getAllClient() {
		List<Client> clientList= clientService.getAllClient();
		return new ResponseEntity<>(clientList,HttpStatus.OK);
	}

	/**
	 * This method is used to delete record based on ClientTypeId
	 * 
	 * @param ClientTypeId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity deleteClient(@RequestParam Integer ClientTypeId) {
		System.out.println("clientTypeId:" + ClientTypeId);
		clientService.deleteClient(ClientTypeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * This is used to update particular client details
	 * 
	 * @param client
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Client> updateClient(@RequestBody Client client) {
		System.out.println("Client:" + client);
		client= clientService.updateClient(client);
		return new ResponseEntity<>(client,HttpStatus.OK);

	}

}
