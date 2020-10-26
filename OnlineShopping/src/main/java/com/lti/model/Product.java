package com.lti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_product")
public class Product {
	@Id
	@SequenceGenerator(name = "productSeq", initialValue = 101, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSeq")
	
	int productId;
	String productName;
	String productDescription;
	double productPrice;
	int productQuantity;
	String productManufacturerName;
	
	@ManyToOne
	@JoinColumn(name="cateogary_id")
	Cateogary cateogary;
	
	@ManyToOne
	@JoinColumn(name="retailer_id")
	Retailer retailer;
	
	
	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

	public int getProductId() {
		return productId;
	}
	
	public Cateogary getCateogary() {
		return cateogary;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public void setCateogary(Cateogary cateogary) {
		this.cateogary = cateogary;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductManufacturerName() {
		return productManufacturerName;
	}
	public void setProductManufacturerName(String productManufacturerName) {
		this.productManufacturerName = productManufacturerName;
	}
	

}
