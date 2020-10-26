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
public class Cateogary {
	
	@Id
	@SequenceGenerator(name = "catSeq", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catSeq")
	int cateogaryId;
	String cateogaryName;
	
	@OneToMany(mappedBy="cateogary",cascade=CascadeType.ALL)
	List<Product> product;
	
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
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
