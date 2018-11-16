package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Client;

import java.util.List;

public interface ClientService {
	public Client createClient(Client client);

	public Client getClient(Integer ClientTypeId);

	public List<Client> getAllClient();

	public String deleteClient(Integer ClientTypeId);

	public Client updateClient(Client client);
}
