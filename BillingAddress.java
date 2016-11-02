package com.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Component
public class BillingAddress {

	@Id
	@NotNull
	private String billingaddressid;
	
	@Column
	private String customerid;
	
	@Column
	@NotBlank(message="please specify main address")
	private String line1;
	
	@Column
	@NotBlank
	private String line2;
	
	@Column
	@NotBlank(message="please specify country")
	private String country;
	
	@Column
	@NotBlank(message="please specify state")
	private String state;
	
	@Column
	@NotBlank(message="please specify city")
	private String city;
	
	@Column
	@NotBlank(message="please specify zipcode")
	private String zipcode;

	public String getBillingaddressid() {
		return billingaddressid;
	}

	public void setBillingaddressid(String billingaddressid) {
		this.billingaddressid = billingaddressid;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}
    
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
}
