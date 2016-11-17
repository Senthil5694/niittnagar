package com.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component("carddetail")
public class CardDetail {
	
	@Id
	@Column
	private String carddetailid;
	
	@Column
	private String cardnumber;
	
	@Column
	private String username;
	
	@Column
	private String expirymonth;
	
	@Column
	private String expiryyear;
	
	@Column
	private String cvnumber;
	
	@Column
	private String nameoncard;
	
	@Column
	private double totalcost;

	public String getCarddetailid() {
		return carddetailid;
	}

	public void setCarddetailid(String carddetailid) {
		this.carddetailid = carddetailid;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getExpirymonth() {
		return expirymonth;
	}

	public void setExpirymonth(String expirymonth) {
		this.expirymonth = expirymonth;
	}

	public String getExpiryyear() {
		return expiryyear;
	}

	public void setExpiryyear(String expiryyear) {
		this.expiryyear = expiryyear;
	}

	public String getCvnumber() {
		return cvnumber;
	}

	public void setCvnumber(String cvnumber) {
		this.cvnumber = cvnumber;
	}
	public String getNameoncard() {
		return nameoncard;
	}

	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}

	public double getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}
	
	
	
	
	
	
	

}
