package com.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.Dao.CartDao;
import com.Dao.CartItemDao;
import com.Dao.ProductDao;
import com.Dao.RegisterDao;
import com.Model.Cart;
import com.Model.CartItem;
import com.Model.Product;
import com.Model.RegisterModel;


@Controller
@RequestMapping("/usercart/user")
public class CartController {
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private RegisterDao registerDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CartItemDao cartitemdao;
	
	@Autowired
	private CartItem cartitem;
	
	@Autowired
	private Cart cart;
	
	@RequestMapping("/cart/{cartid}")
	public @ResponseBody
	Cart getcartbyid(@PathVariable(value="cartid") int cartid){
		return cartDao.getCartById(cartid);
	}
	@RequestMapping(value="/additem/{pid}",method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void additem(@PathVariable(value="pid") String pid,Principal username)
	{
		RegisterModel registerModel=registerDao.getcustomerbyusername(username.getName());
				Cart cart= registerModel.getCart();
		Product product=productDao.get(pid);
		List<CartItem> cartItems=cart.getCartItems();
		for (int i=0; i<cartItems.size(); i++) {
            if(product.getPid()==cartItems.get(i).getProduct().getPid()){
            	CartItem cartitem= cartItems.get(i);
            	cartitem.setPname(product.getName());
            	cartitem.setPrice(product.getPrice());
            	cartitem.setQuantity(cartitem.getQuantity()+1);
            	cartitem.setTotal(product.getPrice()*cartitem.getQuantity());
            	cartitemdao.saveOrUpdate(cartitem);
            	return;
            	
            }
                
            }
		CartItem cartitem= new CartItem();
		cartitem.setProduct(product);
		cartitem.setPname(product.getName());
		cartitem.setPrice(product.getPrice());
		cartitem.setQuantity(1);
		cartitem.setTotal(product.getPrice()*cartitem.getQuantity());
		cartitemdao.saveOrUpdate(cartitem);
	}
	@RequestMapping("/removeitem/{cartitemid}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeitem(@PathVariable(value="cartitemid") int cartitemid)
	{
	 cartitem=cartitemdao.getcartitem(cartitemid);
				cartitemdao.delete(cartitemid);
	}
	@RequestMapping("/clearcartitems/{cartid}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void clearcartitems (@PathVariable(value="cartid") int cartid)
	{
		 cart=cartDao.getCartById(cartid);
		cartDao.delete(cartid);
	}

}
