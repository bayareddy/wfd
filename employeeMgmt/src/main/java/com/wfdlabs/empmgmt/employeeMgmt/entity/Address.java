package com.wfdlabs.empmgmt.employeeMgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer addressId;
	@Column
	public String houseNo;
	@Column
	public String streetNo;
	@Column
	public String street1Address;
	@Column
	public String street2Address;
	@Column
	public String state;
	@Column
	public Integer pincode;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getStreet1Address() {
		return street1Address;
	}

	public void setStreet1Address(String street1Address) {
		this.street1Address = street1Address;
	}

	public String getStreet2Address() {
		return street2Address;
	}

	public void setStreet2Address(String street2Address) {
		this.street2Address = street2Address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

}
