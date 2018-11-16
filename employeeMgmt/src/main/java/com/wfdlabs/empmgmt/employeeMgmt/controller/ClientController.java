package com.wfdlabs.empmgmt.employeeMgmt.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.wfdlabs.empmgmt.employeeMgmt.entity.Client;
import com.wfdlabs.empmgmt.employeeMgmt.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/Client")
public class ClientController {
	@Autowired
	private ClientService clientService;

	@RequestMapping(method = RequestMethod.POST)
	public Client createClient(@RequestBody Client client) {
		System.out.println("Client:" + client);
		client.setUpdateDate(null);
		return clientService.createClient(client);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Client getClient(@RequestParam Integer ClientTypeId) {
		System.out.println("Client:" + ClientTypeId);
		return clientService.getClient(ClientTypeId);
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public List<Client> getAllClient() {
		return clientService.getAllClient();
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteClient(@RequestParam Integer ClientTypeId) {
		System.out.println("clientTypeId:" + ClientTypeId);
		clientService.deleteClient(ClientTypeId);
		return "delete record successfully";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Client updateClient(@RequestBody Client client) {
		System.out.println("Client:" + client);
		return clientService.updateClient(client);

	}

}
