package com.tronicsville.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import org.springframework.stereotype.Component;

@Entity
@Table(name="supplier")
@Component
public class Supplier {
	@Id
	private String id;
	private String name;
	private String address;
	@OneToMany(mappedBy="supplier" ,fetch=FetchType.EAGER)
	private Set<Product> products;
	public Set<Product> getproducts(){
		return products;
	}
	public void setproducts(Set<Product> products){
		this.products=products;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}