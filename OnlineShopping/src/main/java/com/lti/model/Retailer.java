package com.lti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_retailer")
@SequenceGenerator(name = "retailSeq", initialValue = 101, allocationSize = 1)
public class Retailer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "retailSeq")
	private int retailerId;
	private String retailerName;
	private String retailerEmail;

	@ManyToOne
	@JoinColumn(name = "admin_Id")
	private Admin admin;

	@OneToOne
	@JoinColumn(name = "address_Id")
	private AddressRetailer address;
	
	
	public AddressRetailer getAddress() {
		return address;
	}

	public void setAddress(AddressRetailer address) {
		this.address = address;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public String getRetailerEmail() {
		return retailerEmail;
	}

	public void setRetailerEmail(String retailerEmail) {
		this.retailerEmail = retailerEmail;
	}
}
