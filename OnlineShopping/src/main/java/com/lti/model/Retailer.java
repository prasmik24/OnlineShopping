package com.lti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@OneToOne(mappedBy = "retailer", cascade = CascadeType.ALL)
	private AddressRetailer address;
	
	@OneToMany(mappedBy = "retailer", cascade = CascadeType.ALL)
	List<Product> products;
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
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
