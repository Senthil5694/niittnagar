package com.tronicsville.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="product")
@Component
public class Product {
	@Id
	private String id;
	private String name;
	private String price;
	@ManyToOne
	@JoinColumn(name="category_id" ,insertable=false ,updatable=false ,nullable=false)
	private Category catagory;
	
	@ManyToOne
	@JoinColumn(name="supplier_id" ,insertable=false ,updatable=false, nullable=false)
	private Supplier supplier;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	

}
