package com.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Component("shippingaddress")
public class ShippingAddress {
	
	@Id
	@Column
	private String shippingaddressid;
	
	@Column
	@NotBlank(message="please specify main address")
	private String line1;
	
	@Column
	@NotBlank
	private String line2;
	
	@Column
	@NotBlank(message="please specify city")
	private String city;
	
	@Column
	@NotBlank(message="please specify state")
	private String state;
	
	@Column
	@NotBlank(message="please specify country")
	private String country;
	
	@Column
	@NotBlank(message="please specify zipcode")
	private String zipcode;
	
	@Column
	private String username;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getShippingaddressid() {
		return shippingaddressid;
	}

	public void setShippingaddressid(String shippingaddressid) {
		this.shippingaddressid = shippingaddressid;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	

}
