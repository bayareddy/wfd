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

	@Override
	public Client createClient(Client client) {
		System.out.println("Save client record ");
		return clientRepository.save(client);
	}

	@Override
	public Client getClient(Integer ClientTypeId) {
		return clientRepository.getOne(ClientTypeId);
	}

	@Override
	public List<Client> getAllClient() {
		return clientRepository.findAll();
	}

	@Override
	public String deleteClient(Integer ClientTypeId) {
		System.out.println("delete client record ");
		clientRepository.deleteById(ClientTypeId);
		return "delete record successfully";
	}

	@Override
	public Client updateClient(Client client) {
		System.out.println("update and save client record");
		return clientRepository.save(client);
	}
}
