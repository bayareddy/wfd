package com.wfdlabs.empmgmt.employeeMgmt.service;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Client;

import java.util.List;

public interface ClientService {
	/**
	 * This method is used to create client details
	 * 
	 * @param client
	 * @return
	 */
	public Client createClient(Client client);

	/**
	 * This method is used to get particular client record based on ClientTypeId
	 * 
	 * @param ClientTypeId
	 * @return
	 */
	public Client getClient(Integer ClientTypeId);

	/**
	 * This method is used to return all the client details
	 * 
	 * @param
	 * @return
	 */
	public List<Client> getAllClient();

	/**
	 * This method is used to delete record based on leaveId
	 * 
	 * @param leaveId
	 * @return
	 */
	public String deleteClient(Integer ClientTypeId);

	/**
	 * This is used to update particular client details
	 * 
	 * @param client
	 * @return
	 */
	public Client updateClient(Client client);
}
