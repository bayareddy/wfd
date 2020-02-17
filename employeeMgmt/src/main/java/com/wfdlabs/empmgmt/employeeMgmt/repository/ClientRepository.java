package com.wfdlabs.empmgmt.employeeMgmt.repository;

import com.wfdlabs.empmgmt.employeeMgmt.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
