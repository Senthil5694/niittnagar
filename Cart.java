package com.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
public class Cart implements Serializable {
	
	private static final long serialVersionUID = 13L;
	@Id
	@GeneratedValue
private int cartid;
	

	private double grandtotal;
	
	@OneToMany(mappedBy= "cart", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private List<CartItem> cartItems;

	@OneToOne
	@JoinColumn(name="username")
	@JsonIgnore
	private RegisterModel registerModel;
	
	public RegisterModel getRegisterModel() {
		return registerModel;
	}

	public void setRegisterModel(RegisterModel registerModel) {
		this.registerModel = registerModel;
	}
	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public double getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	
}