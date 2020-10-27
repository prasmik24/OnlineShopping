package com.lti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="tbl_cateogary")
public class Category {
	
	//Category misspelt as Cateogary
	
	@Id
	@SequenceGenerator(name = "catSeq", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catSeq")
	int cateogaryId;
	String cateogaryName;
	
	@OneToMany(mappedBy="cateogary",cascade=CascadeType.ALL)
	List<Product> products;
	
	
	public List<Product> getProduct() {
		return products;
	}
	public void setProduct(List<Product> products) {
		this.products = products;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getCateogaryId() {
		return cateogaryId;
	}
	public void setCateogaryId(int cateogaryId) {
		this.cateogaryId = cateogaryId;
	}
	public String getCateogaryName() {
		return cateogaryName;
	}
	public void setCateogaryName(String cateogaryName) {
		this.cateogaryName = cateogaryName;
	}
	
	

}
