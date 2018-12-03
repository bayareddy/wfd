package com.wfdlabs.empmgmt.employeeMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wfdlabs.empmgmt.employeeMgmt.entity.Client;
import com.wfdlabs.empmgmt.employeeMgmt.repository.ClientRepository;
import com.wfdlabs.empmgmt.employeeMgmt.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepository clientRepository;

	/**
	 * This method is used to create the client details
	 * 
	 * @param client
	 * @return
	 */

	@Override
	public Client createClient(Client client) {
		System.out.println("Save client record ");
		return clientRepository.save(client);
	}

	/**
	 * This method is used to get particular client record based on ClientTypeId
	 * 
	 * @param ClientTypeId
	 * @return
	 */
	@Override
	public Client getClient(Integer ClientTypeId) {
		return clientRepository.findById(ClientTypeId).get();
	}

	/**
	 * This method is used to get all the client details
	 * 
	 * @param
	 * @return
	 */
	@Override
	public List<Client> getAllClient() {
		return clientRepository.findAll();
	}

	/**
	 * This method is used to delete record based on ClientTypeId
	 * 
	 * @param ClientTypeId
	 * @return
	 */

	@Override
	public String deleteClient(Integer ClientTypeId) {
		System.out.println("delete client record ");
		clientRepository.deleteById(ClientTypeId);
		return "delete record successfully";
	}

	/**
	 * This is used to update particular client details
	 * 
	 * @param client
	 * @return
	 */
	@Override
	public Client updateClient(Client client) {
		System.out.println("update and save client record");
		return clientRepository.save(client);
	}
}
