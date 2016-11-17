package com.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Order {
		@Id
		@Column
		private String orderid;
		
		@OneToOne
		@JoinColumn(name="cartid" ,updatable=false, insertable=false,nullable=false)
		private Cart cart;
		
		@OneToOne
		@JoinColumn(name="username" ,updatable=false, insertable=false,nullable=false)
		private RegisterModel registermodel;

		public String getOrderid() {
			return orderid;
		}

		public void setOrderid(String orderid) {
			this.orderid = orderid;
		}

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}

		public RegisterModel getRegistermodel() {
			return registermodel;
		}

		public void setRegistermodel(RegisterModel registermodel) {
			this.registermodel = registermodel;
		}
		
		
		
		
		
		
		


}
